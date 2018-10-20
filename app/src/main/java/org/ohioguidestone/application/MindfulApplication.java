package org.ohioguidestone.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import io.realm.Realm;

public class MindfulApplication extends Application {
    private boolean isFirstAppStartup;
    public Realm realm;
    // Figures out if this is the first time the application has ever been started
    // by checking to see if there is any user data in the database
    private boolean isFirstAppStartup() {
        return true;
    }

    public boolean getFirstStartup() {
        return this.isFirstAppStartup;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        // Get a Realm instance for this thread
        realm = Realm.getDefaultInstance();

        this.isFirstAppStartup = isFirstAppStartup();
    }
}
