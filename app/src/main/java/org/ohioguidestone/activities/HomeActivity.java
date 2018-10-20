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

        findViewById(R.id.socialCard).setOnClickListener((view) -> {
            toggleVisibility(R.id.socialActivityDescription);
            toggleVisibility(R.id.socialButton);
            findViewById(R.id.relaxActivityDescription).setVisibility(View.GONE);
            findViewById(R.id.relaxButton).setVisibility(View.GONE);
            findViewById(R.id.physicalActivityDescription).setVisibility(View.GONE);
            findViewById(R.id.physicalButton).setVisibility(View.GONE);
        });
        findViewById(R.id.relaxCard).setOnClickListener((view) -> {
            toggleVisibility(R.id.relaxActivityDescription);
            toggleVisibility(R.id.relaxButton);
            findViewById(R.id.socialActivityDescription).setVisibility(View.GONE);
            findViewById(R.id.socialButton).setVisibility(View.GONE);
            findViewById(R.id.physicalActivityDescription).setVisibility(View.GONE);
            findViewById(R.id.physicalButton).setVisibility(View.GONE);
        });
        findViewById(R.id.physicalCard).setOnClickListener((view) -> {
            toggleVisibility(R.id.physicalActivityDescription);
            toggleVisibility(R.id.physicalButton);
            findViewById(R.id.relaxActivityDescription).setVisibility(View.GONE);
            findViewById(R.id.relaxButton).setVisibility(View.GONE);
            findViewById(R.id.socialActivityDescription).setVisibility(View.GONE);
            findViewById(R.id.socialButton).setVisibility(View.GONE);

        });

        Realm realm = Realm.getDefaultInstance();

        String feeling = sharedPref.getString(getString(R.string.current_feelings_key), "fearful");
        final RealmResults<Activities> activities =  realm.where(Activities.class).equalTo("tags.name", feeling.toLowerCase()).findAll();

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


        Activities sActivity = socialActivities.get( (int) (Math.random() * socialActivities.size()) );
        Activities rActivity = relaxingActivities.get((int) (Math.random() * relaxingActivities.size()) );
        Activities pActivity = physicalActivities.get((int) (Math.random() * physicalActivities.size()) );

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

        View socialActivity = findViewById(R.id.socialButton);
        socialActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), ActivityActivity.class);
                intent.putExtra("name", sActivity.getName());
                intent.putExtra("description", sActivity.getDescription());
                intent.putExtra("image", sActivity.getIcon());

                startActivity(intent);
            }
        });

        View relaxActivity = findViewById(R.id.relaxButton);
        relaxActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), ActivityActivity.class);
                intent.putExtra("name", rActivity.getName());
                intent.putExtra("description", rActivity.getDescription());
                intent.putExtra("image", rActivity.getIcon());
                startActivity(intent);
            }
        });
        View physicalActivity = findViewById(R.id.physicalButton);
        physicalActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), ActivityActivity.class);
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

        summary.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), SummaryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toggleVisibility(int view) {
        View description = findViewById(view);
        if(description.getVisibility() == View.GONE) {
            description.setVisibility(View.VISIBLE);
        } else {
            description.setVisibility(View.GONE);
        }
    }




}
