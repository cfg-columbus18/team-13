package org.ohioguidestone.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class UserModel implements Serializable {
    private String name;
    private String avatarIcon;
    private String happyPicture;
    private LinkedList<Long> lovedContacts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarIcon() {
        return avatarIcon;
    }

    public void setAvatarIcon(String avatarIcon) {
        this.avatarIcon = avatarIcon;
    }

    public String getHappyPicture() {
        return happyPicture;
    }

    public void setHappyPicture(String happyPicture) {
        this.happyPicture = happyPicture;
    }

    public List<Long> getLovedContacts() {
        return lovedContacts;
    }

    public void addLovedContact(long contactID) {
        lovedContacts.add(contactID);
    }

    public void removeLovedContact(long contactID) {
        lovedContacts.remove(contactID);
    }
}
