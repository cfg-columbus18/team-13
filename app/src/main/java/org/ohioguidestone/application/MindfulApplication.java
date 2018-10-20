package org.ohioguidestone.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import org.ohioguidestone.R;
import org.ohioguidestone.database.DatabaseHelper;

public class MindfulApplication extends Application {
    private boolean isFirstAppStartup;

    // Figures out if this is the first time the application has ever been started
    // by checking to see if there is any user data in the database
    private boolean isFirstAppStartup() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        // Returns true if there is no name stored, indicating first app startup
        return !sharedPref.getBoolean(getString(R.string.saved_user_created_key), false);
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
