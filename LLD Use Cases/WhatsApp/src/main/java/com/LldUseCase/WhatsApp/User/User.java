package com.LldUseCase.WhatsApp.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.LldUseCase.WhatsApp.Enums.EnumUserStatus;
import com.LldUseCase.WhatsApp.Messages.Message;

import static com.LldUseCase.WhatsApp.Utils.GenerateUniqueId.getUniqueUUID;

public class User {
    private String userId;
    private String userName;
    private String phoneNumber;
    private EnumUserStatus enumUserStatus=EnumUserStatus.ONLINE;
    private LocalDateTime lastSeen;
    private  List<String> chatIds;

    public User(String userName, String phoneNumber) {
        this.userId = getUniqueUUID();
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        chatIds=new ArrayList<>();
    }

    public void setEnumUserStatus(EnumUserStatus enumUserStatus) {
        this.enumUserStatus = enumUserStatus;
        if(enumUserStatus.equals(EnumUserStatus.OFFLINE)){
            setLastSeenTime();
        }
    }

    public void addChat(String chatId){
        chatIds.add(chatId);
    }

    public void setLastSeenTime(){
        lastSeen=LocalDateTime.now();
    }

    public String getLastSeenTime(){
        return lastSeen.toString();
    }

    public String getUserName(){
        return userName;
    }

    public String getUserId(){
        return userId;
    }

    public void receiveMessage(Message message,String chatId){
        System.out.println("Myself "+userName+" Recieved the Message as "+message.getMessageInfo()); 
    }

    public List<String> getChatIds(){
        return chatIds;
    }

}
