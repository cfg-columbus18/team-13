package org.ohioguidestone.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ohioguidestone.R;
import org.ohioguidestone.application.MindfulApplication;
import org.ohioguidestone.fragments.OnboardNameFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (((MindfulApplication) this.getApplication()).getFirstStartup()) {
            FragmentManager manager = this.getFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.onboarding_fragment_holder, OnboardNameFragment.newInstance());
            transaction.commit();
        } else {
            enableMainLayout();
        }
    }

    public void enableMainLayout() {
        TextView statusCheckText = findViewById(R.id.how_are_you_text);
        statusCheckText.setVisibility(View.VISIBLE);
    }
}
