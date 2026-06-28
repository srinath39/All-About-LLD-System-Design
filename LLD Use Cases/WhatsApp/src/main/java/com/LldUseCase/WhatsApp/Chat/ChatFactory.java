package com.LldUseCase.WhatsApp.Chat;

import com.LldUseCase.WhatsApp.Enums.EnumChatType;
import com.LldUseCase.WhatsApp.User.User;

import java.util.List;

public class ChatFactory {
    public static AbstractChat createChat(EnumChatType type,String chatName, List<User> users){
        return switch(type){
            case GROUP -> new GroupChat(chatName,users);
            case SINGLE -> new SingleChat(chatName,users);
        };
    }
}