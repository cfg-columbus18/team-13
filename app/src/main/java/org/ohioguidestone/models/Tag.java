package org.ohioguidestone.models;

import io.realm.RealmObject;

public class Tag extends RealmObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
