package org.ohioguidestone.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import org.ohioguidestone.database.DatabaseHelper;

public class MindfulApplication extends Application {
    private boolean isFirstAppStartup;

    // Figures out if this is the first time the application has ever been started
    // by checking to see if there is any user data in the database
    private boolean isFirstAppStartup() {
        DatabaseHelper dbHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        return true;
    }

    public boolean getFirstStartup() {
        return this.isFirstAppStartup;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper.createInstance(this);
        this.isFirstAppStartup = isFirstAppStartup();
    }
}
