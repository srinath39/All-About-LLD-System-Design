package com.LldUseCase.WhatsApp.Chat;

import java.util.List;

import com.LldUseCase.WhatsApp.User.User;


public class SingleChat extends AbstractChat {
    public SingleChat(String chatName, List<User> users) {
        super(chatName, users);

    }

    public String getChatName(User user){
        User otherUser=getUsers().stream().filter(u->u!=user).findFirst().get();
        return otherUser.getUserName();
    }   
}
