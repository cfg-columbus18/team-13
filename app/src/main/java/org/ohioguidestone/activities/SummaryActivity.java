package org.ohioguidestone.activities;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import org.ohioguidestone.R;
import org.ohioguidestone.models.Activities;
import org.ohioguidestone.models.Usage;

import java.util.List;

import io.realm.Realm;

public class SummaryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String summaryText = "";
        Realm realm = Realm.getDefaultInstance();
        List<Activities> activities = realm.where(Activities.class).isNotEmpty("usage").limit(10).findAll();
        for(Activities activity: activities) {
            for(Usage use: activity.getUsage()) {
                summaryText += use.getDateCompleted() + " : " + activity.getName() + " (" + use.getTimeSpent() + "m)" + "\n";
            }
        }

        setContentView(R.layout.activity_summary);
        TextView view = (TextView) findViewById(R.id.summaryText);
        view.setText(summaryText);
    }

}
