package com.LldUseCase.WhatsApp.Messages;

import com.LldUseCase.WhatsApp.Enums.EnumMessageType;

public interface IMessageType {
    public String loadTheMessaeg();
    public EnumMessageType getMessageType();
}
