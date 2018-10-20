package org.ohioguidestone.models;

import java.util.Date;

import io.realm.RealmObject;

public class Usage extends RealmObject {
    private int rating;
    private String dateCompleted;
    private int timeSpent;
    //private Date createdAt = new Date();

    public int getRating() {

        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
}
