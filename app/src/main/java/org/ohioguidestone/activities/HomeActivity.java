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

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //get preference for activity from intent passed by daily preference page
        //string/activity_id preference =

        findViewById(R.id.socialCard).setOnClickListener(toggleVisibility(R.id.socialActivityDescription));
        findViewById(R.id.relaxCard).setOnClickListener(toggleVisibility(R.id.relaxActivityDescription));
        findViewById(R.id.physicalCard).setOnClickListener(toggleVisibility(R.id.physicalActivityDescription));


        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
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
                intent.putExtra("activity", "ID FOR ACTIVITY");
                startActivity(intent);
            }
        });

        TextView relaxActivity = (TextView) findViewById(R.id.relaxActivityDescription);
        relaxActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), SettingsActivity.class);
                intent.putExtra("activity", "ID FOR ACTIVITY");
                startActivity(intent);
            }
        });
        TextView physicalActivity = (TextView) findViewById(R.id.physicalActivityDescription);
        physicalActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), SettingsActivity.class);
                intent.putExtra("activity", "ID FOR ACTIVITY");
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
