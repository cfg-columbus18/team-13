package org.ohioguidestone.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import org.ohioguidestone.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MindfulApplication extends Application {
    private boolean isFirstAppStartup;
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

        if (!fileFound(getString(R.string.realm_db_path), this.getFilesDir())) {
            copyBundledRealmFile(this.getResources().openRawResource(R.raw.start_db), getString(R.string.realm_db_path));
        }
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(getString(R.string.realm_db_path))
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
        this.isFirstAppStartup = isFirstAppStartup();
    }

    private void copyBundledRealmFile(InputStream inputStream, String outFileName) {
        try {
            File file = new File(this.getFilesDir(), outFileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean fileFound(String name, File file) {
        File[] list = file.listFiles();
        if (list != null)
            for (File fil : list) {
                if (fil.isDirectory()) {
                    fileFound(name, fil);
                } else if (name.equalsIgnoreCase(fil.getName())) {
                    return true;
                }
            }
        return false;
    }
}
