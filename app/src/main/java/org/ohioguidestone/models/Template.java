package org.ohioguidestone.models;

import io.realm.RealmObject;

public class Template extends RealmObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
