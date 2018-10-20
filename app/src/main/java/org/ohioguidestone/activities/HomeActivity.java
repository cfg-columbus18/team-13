package org.ohioguidestone.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

import org.ohioguidestone.R;
import org.ohioguidestone.application.MindfulApplication;
import org.ohioguidestone.models.Activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        //get preference for activity from intent passed by daily preference page
        //string/activity_id preference =

        findViewById(R.id.socialCard).setOnClickListener(toggleVisibility(R.id.socialActivityDescription));
        findViewById(R.id.relaxCard).setOnClickListener(toggleVisibility(R.id.relaxActivityDescription));
        findViewById(R.id.physicalCard).setOnClickListener(toggleVisibility(R.id.physicalActivityDescription));

        Realm realm = Realm.getDefaultInstance();

        String feeling = sharedPref.getString(getString(R.string.current_feelings_key), "fearful");
        final RealmResults<Activities> activities =  realm.where(Activities.class).equalTo("tags.name", feeling).findAll();

        List<Activities> socialActivities = new ArrayList<Activities>();
        List<Activities> physicalActivities = new ArrayList<Activities>();
        List<Activities> relaxingActivities = new ArrayList<Activities>();

        for(Activities activity: activities) {
            switch (activity.getCategory().getName()) {
                case "social":
                    socialActivities.add(activity);
                    break;
                case "physical":
                    physicalActivities.add(activity);
                    break;
                case "relaxation":
                    relaxingActivities.add(activity);
                    break;
            }
        }

        if(socialActivities.isEmpty()) {
            socialActivities = realm.where(Activities.class).equalTo("category.name", "social").findAll();
        }
        if(physicalActivities.isEmpty()) {
            physicalActivities = realm.where(Activities.class).equalTo("category.name", "physical").findAll();
        }
        if(relaxingActivities.isEmpty()) {
            relaxingActivities = realm.where(Activities.class).equalTo("category.name", "relaxation").findAll();
        }

//        Collections.shuffle(socialActivities);
//        Collections.shuffle(physicalActivities);
//        Collections.shuffle(relaxingActivities);

        Activities sActivity = socialActivities.get(0);
        Activities rActivity = relaxingActivities.get(0);
        Activities pActivity = physicalActivities.get(0);

        ((TextView) findViewById(R.id.socialActivityTitle)).setText(sActivity.getName());
        ((TextView) findViewById(R.id.relaxActivityTitle)).setText(rActivity.getName());
        ((TextView) findViewById(R.id.physicalActivityTitle)).setText(pActivity.getName());
        ((TextView) findViewById(R.id.socialActivityDescription)).setText(sActivity.getDescription());
        ((TextView) findViewById(R.id.relaxActivityDescription)).setText(rActivity.getDescription());
        ((TextView) findViewById(R.id.physicalActivityDescription)).setText(pActivity.getDescription());


        String name = sharedPref.getString(getString(R.string.saved_name_key), "Johnny Appleseed");
        String avatarIcon = sharedPref.getString(getString(R.string.saved_avatar_key), getResources().getResourceEntryName(R.drawable.ic_001_dog));
        int avatarResource = getResources().getIdentifier(avatarIcon, "drawable", getPackageName());

        ImageView profileIcon = (ImageView)findViewById(R.id.userImage);
        profileIcon.setImageResource(avatarResource);
        
        ((TextView) findViewById(R.id.userName)).setText(name);

        //choose activities from database based on preferences
        //socialAcitivityId = MostPopularOption based on tag selected from daily preference screen

        TextView socialActivity = (TextView) findViewById(R.id.socialActivityDescription);
        socialActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), SettingsActivity.class);
                intent.putExtra("name", sActivity.getName());
                intent.putExtra("description", sActivity.getDescription());
                intent.putExtra("image", sActivity.getIcon());

                startActivity(intent);
            }
        });

        TextView relaxActivity = (TextView) findViewById(R.id.relaxActivityDescription);
        relaxActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), SettingsActivity.class);
                intent.putExtra("name", rActivity.getName());
                intent.putExtra("description", rActivity.getDescription());
                intent.putExtra("image", rActivity.getIcon());
                startActivity(intent);
            }
        });
        TextView physicalActivity = (TextView) findViewById(R.id.physicalActivityDescription);
        physicalActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), SettingsActivity.class);
                intent.putExtra("name", pActivity.getName());
                intent.putExtra("description", pActivity.getDescription());
                intent.putExtra("image", pActivity.getIcon());
                startActivity(intent);
            }
        });

        Button settings = (Button) findViewById(R.id.settingsButton);
        Button summary = (Button) findViewById(R.id.summaryButton);

        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), SummaryActivity.class);
                startActivity(intent);
            }
        });
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
