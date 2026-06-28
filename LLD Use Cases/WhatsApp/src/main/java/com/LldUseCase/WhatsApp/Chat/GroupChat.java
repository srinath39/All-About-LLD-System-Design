package com.LldUseCase.WhatsApp.Chat;

import java.util.ArrayList;
import java.util.List;

import com.LldUseCase.WhatsApp.User.User;

public class GroupChat extends AbstractChat {
    private final List<User> admins;

    public GroupChat(String chatName, List<User> users) {
        super(chatName, users);
        this.admins = new ArrayList<>();
        admins.add(users.get(0));
    }

    public void addMember(User user){
        if (user != null && !getUsers().contains(user)) {
            getUsers().add(user);
        }
    }

    public void removeMember(User user) {
        if (user != null) {
            getUsers().remove(user);
            admins.remove(user);
        }
    }

    public void makeUserAdmin(User user) {
        if (user != null && getUsers().contains(user) && !admins.contains(user)) {
            admins.add(user);
        }
    }

    public List<User> getAdmins() {
        return admins;
    }

    public boolean isUserAnAdmin(User user){
        return getAdmins().contains(user);
    }


}