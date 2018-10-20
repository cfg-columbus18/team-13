package org.ohioguidestone.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import org.ohioguidestone.R;
import org.ohioguidestone.application.MindfulApplication;
import org.ohioguidestone.models.Activities;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.socialCard).setOnClickListener(toggleVisibility(R.id.socialActivityDescription));
        findViewById(R.id.relaxCard).setOnClickListener(toggleVisibility(R.id.relaxActivityDescription));
        findViewById(R.id.physicalCard).setOnClickListener(toggleVisibility(R.id.physicalActivityDescription));

        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.saved_name_key), "Jimmy Johns");
        editor.commit();
        String name = sharedPref.getString(getString(R.string.saved_name_key), "Boom Shaka");
        ((TextView) findViewById(R.id.userName)).setText(name);

        Realm realm = Realm.getDefaultInstance();
        List<Activities> activities = realm.where(Activities.class).findAll();
        Activities x = ((RealmResults<Activities>) activities).first();

        ((TextView) findViewById(R.id.socialActivityTitle)).setText(x.getName());

    }

    private View.OnClickListener toggleVisibility(int view) {
        return (v) ->  {
            View description = findViewById(view);
            if(description.getVisibility() == View.GONE) {
                description.setVisibility(View.VISIBLE);
            } else {
                description.setVisibility(View.GONE);
            }
        };
    }




}
