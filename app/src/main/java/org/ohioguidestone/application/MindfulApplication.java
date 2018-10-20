package org.ohioguidestone.application;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

import org.ohioguidestone.R;
import org.ohioguidestone.database.DatabaseHelper;

import java.util.Calendar;

public class MindfulApplication extends Application {
    private boolean isFirstAppStartup;

    // Figures out if this is the first time the application has ever been started
    // by checking to see if there is any user data in the database
    private boolean isFirstAppStartup() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        // Returns true if the/re is no name stored, indicating first app startup
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


        //this will set it to repeat at 7
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {

            Intent alarmIntent = new Intent(this, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 1);

            manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }
    }
}
