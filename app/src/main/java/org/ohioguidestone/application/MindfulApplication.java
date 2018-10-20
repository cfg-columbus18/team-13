package org.ohioguidestone.application;

import android.app.Application;

import org.ohioguidestone.database.DatabaseHelper;

public class MindfulApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper.createInstance(this);
    }
}
