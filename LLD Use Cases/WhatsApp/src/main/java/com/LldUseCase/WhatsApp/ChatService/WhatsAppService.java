package com.LldUseCase.WhatsApp.ChatService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.LldUseCase.WhatsApp.Chat.AbstractChat;
import com.LldUseCase.WhatsApp.Chat.ChatFactory;
import com.LldUseCase.WhatsApp.Chat.GroupChat;
import com.LldUseCase.WhatsApp.Enums.EnumChatType;
import com.LldUseCase.WhatsApp.Enums.EnumMessageType;
import com.LldUseCase.WhatsApp.Messages.Message;
import com.LldUseCase.WhatsApp.Messages.MessageFactory;
import com.LldUseCase.WhatsApp.User.User;

public class WhatsAppService {
    private static WhatsAppService whatsAppService;
    private List<User> allUsers=new ArrayList<>();
    private HashMap<String,User> userMap=new HashMap<>();
    private List<AbstractChat> allChats=new ArrayList<>();
    private HashMap<String,AbstractChat> allChatsMap=new HashMap<>();
    private List<AbstractChat> allSingleChats=new ArrayList<>();
    private List<AbstractChat> allGroupChats=new ArrayList<>();

    private WhatsAppService(){
    }

    public static WhatsAppService getInstance(){
        if(whatsAppService==null){
            whatsAppService=new WhatsAppService();
        }
        return whatsAppService;
    }

    public User createUserAccount(String userName,String phoneNumber){
        User user=new User(userName, phoneNumber);
        allUsers.add(user);
        userMap.put(user.getUserId(),user);
        return user;
    }

    public AbstractChat createSingleChat(String userId, String otherUserId){
        AbstractChat chat=ChatFactory.createChat(EnumChatType.SINGLE,null,Arrays.asList(userMap.get(otherUserId),userMap.get(userId)));
        userMap.get(userId).addChat(chat.getChatId());
        userMap.get(otherUserId).addChat(chat.getChatId());
        allChats.add(chat);
        allSingleChats.add(chat);
        allChatsMap.put(chat.getChatId(),chat);
        return chat;
    }

    public void createGroupChat(String userId,List<String> allUserIds,String chatName){
        List<User> users=allUserIds.stream().map(id->userMap.get(id)).toList();
        users.add(userMap.get(userId));
        AbstractChat chat=ChatFactory.createChat(EnumChatType.GROUP,chatName,users);
        users.stream().forEach(u->u.addChat(chat.getChatId()));
        allChats.add(chat);
        allGroupChats.add(chat);
        allChatsMap.put(chat.getChatId(),chat);
    }

    public void sendMessage(String userId, EnumMessageType enumMessageType,Object messageInfo,String chatId){
        // user 
        User user=userMap.get(userId);
        // chats ?
        boolean isChatPresent=user.getChatIds().stream().anyMatch(c->c.equals(chatId));

        if(!isChatPresent){
            throw new RuntimeException("Chat not found");
        }
        // chat 
        AbstractChat chat=allChatsMap.get(chatId);
        // message 
        Message message=new Message(MessageFactory.getmMessageType(enumMessageType, messageInfo),LocalDateTime.now(),user,chatId);
        
        // send the message 
        chat.loadMessage(message, user);

    }

    public void addMembersToTheGroupChat(String userId,String newUserId,String chatId){
        if(!userMap.containsKey(userId)){
            throw new RuntimeException("User not found");
        }

        if(!allChatsMap.containsKey(chatId)){
            throw new RuntimeException("Chat not found");
        }

        if(!allGroupChats.contains(chatId)){
            throw new RuntimeException("Not a group chat");
        }

        User user =userMap.get(userId);
        User newUser =userMap.get(newUserId);
        AbstractChat chat=allChatsMap.get(chatId);

        GroupChat gc=(GroupChat)chat;
        
        if(!gc.isUserAnAdmin(user)){
            throw new RuntimeException("Not an Admin");
        }
        gc.addMember(newUser);
    }    
}
