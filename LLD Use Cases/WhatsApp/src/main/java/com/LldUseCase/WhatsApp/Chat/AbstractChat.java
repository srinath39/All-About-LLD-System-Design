package com.LldUseCase.WhatsApp.Chat;

import com.LldUseCase.WhatsApp.Messages.Message;
import com.LldUseCase.WhatsApp.User.User;
import static com.LldUseCase.WhatsApp.Utils.GenerateUniqueId.getUniqueUUID;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractChat {

    private String chatId;
    private String chatName;
    private List<User> users;
    private List<Message> messages;

    protected AbstractChat(String chatName, List<User> users) {
        this.chatId = getUniqueUUID();
        this.chatName = chatName;
        this.users = new ArrayList<>(users);
        this.messages = new ArrayList<>();
    }

    public String getChatId(){
        return this.chatId;
    }

    public void setChatName(String chatName){
        this.chatName = chatName;
    }
    public List<User> getUsers(){
        return this.users;
    }
    public List<Message> getMessages(){
        return this.messages;
    }

    public  void loadMessage(Message message, User user){
        messages.add(message);
        sendToAllUsers();
    }

    public  void sendToAllUsers(){
        Message lastMessage = getLastMessage();
        for(User user: users){
            if(lastMessage.getMessageOwner()!=user){
                user.receiveMessage(lastMessage,this.getChatId());
            }
        }
    }

    public Message getLastMessage(){
        return messages.get(messages.size() -1);
    }

    public String getChatName(){
        return chatName;
    }

}
