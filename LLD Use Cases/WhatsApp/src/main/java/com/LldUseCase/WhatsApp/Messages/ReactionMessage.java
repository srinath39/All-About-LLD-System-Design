package com.LldUseCase.WhatsApp.Messages;

import com.LldUseCase.WhatsApp.Enums.EnumMessageType;

public class ReactionMessage implements IMessageType {
    private Object object;
    private EnumMessageType enumMessageType=EnumMessageType.REACTION;

    public ReactionMessage(Object object){
        this.object=object;
    }

    public String loadTheMessaeg(){
        // SOME PREPROCESS
        return object.toString();
    }

    public EnumMessageType getMessageType() {
        return enumMessageType; 
    }
    
}
