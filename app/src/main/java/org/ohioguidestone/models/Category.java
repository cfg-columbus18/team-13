package org.ohioguidestone.models;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Category extends RealmObject {
    private String name;

//    public RealmList<Activities> getActivites() {
//        return activites;
//    }
//
//    public void setActivites(RealmList<Activities> activites) {
//        this.activites = activites;
//    }
//
//    private RealmList<Activities> activites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
