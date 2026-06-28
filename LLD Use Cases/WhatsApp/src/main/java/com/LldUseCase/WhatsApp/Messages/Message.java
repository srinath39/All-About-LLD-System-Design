package com.LldUseCase.WhatsApp.Messages;

import java.time.LocalDateTime;

import com.LldUseCase.WhatsApp.Enums.EnumMessageStatus;
import com.LldUseCase.WhatsApp.User.User;
import static com.LldUseCase.WhatsApp.Utils.GenerateUniqueId.getUniqueUUID;

public class Message {
    private String messageId;
    private IMessageType messageType;
    private LocalDateTime timeStamp;
    private User user;
    private EnumMessageStatus enumMessageStatus=EnumMessageStatus.SENT;
    private String chatId;    

    public Message(IMessageType messageType,LocalDateTime timeStamp,User user,String chatId){
        this.messageId=getUniqueUUID();
        this.messageType=messageType;
        this.timeStamp=timeStamp;
        this.user=user;
        this.chatId=chatId;
    }

    public String getMessageInfo(){
        return messageType.loadTheMessaeg();
    }

    public String getMessageTimeStamp(){
        return timeStamp.toString();
    } 

    public void setMessageStatus(EnumMessageStatus enumMessageStatus){
        this.enumMessageStatus=enumMessageStatus;
    }

    public User getMessageOwner(){
        return user;
    }


}



