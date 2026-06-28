package com.LldUseCase.WhatsApp.Messages;

import com.LldUseCase.WhatsApp.Enums.EnumMessageType;

public class TextMessage implements IMessageType{
    private String textMessage;
    private EnumMessageType enumMessageType=EnumMessageType.TEXT;

    public TextMessage(String textMessage){
        this.textMessage=textMessage;
    }

    public String loadTheMessaeg(){
        return textMessage;
    }

    public EnumMessageType getMessageType() {
        return enumMessageType;
    }
}
