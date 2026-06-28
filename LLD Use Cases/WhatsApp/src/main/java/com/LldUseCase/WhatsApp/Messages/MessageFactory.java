package com.LldUseCase.WhatsApp.Messages;

import com.LldUseCase.WhatsApp.Enums.EnumMessageType;

public class MessageFactory {

    public static IMessageType getmMessageType(EnumMessageType enumMessageType,Object messageData){
        IMessageType messageType=null;
        switch (enumMessageType) {
            case EnumMessageType.TEXT:
                messageType=new TextMessage((String)messageData);
                break;
            case EnumMessageType.REACTION:
                messageType=new ReactionMessage(messageData);
            default:
                break;
        }
        return messageType;
    }
}
