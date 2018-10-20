package org.ohioguidestone.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import org.ohioguidestone.R;
import org.ohioguidestone.application.MindfulApplication;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (((MindfulApplication) this.getApplication()).getFirstStartup()) {
            FragmentManager manager = this.getFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.onb)
        } else {

        }
    }
}
