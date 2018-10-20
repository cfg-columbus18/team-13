package org.ohioguidestone.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.ohioguidestone.R;
import org.ohioguidestone.models.Activities;
import org.w3c.dom.Text;

import io.realm.Realm;

public class ActivityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        //Get info from intent for the activity
        Intent intent = getIntent();
        String activityName = intent.getStringExtra("name");
        String activityImage = intent.getStringExtra("image");
        String activityDescription = intent.getStringExtra("description");

        ImageView heartImage = (ImageView) findViewById(R.id.activityHeart);
        heartImage.setOnClickListener(view->{
            //database backend note that they liked it
        });

        TextView title = (TextView) findViewById(R.id.activityTitle);
        title.setText(activityName); //set title based on data from intent

        ImageView image = (ImageView) findViewById(R.id.activityImage);
        Resources resources = this.getResources();
        final int imageId = getResources().getIdentifier(activityImage, "drawable", this.getPackageName());
        image.setImageResource(imageId); //set image based on data from intent


        TextView description = findViewById(R.id.activityDescription);
        description.setText(activityDescription); //set description based on data from intent

        TextView minuteView = findViewById(R.id.activityCompletedTime);
        minuteView.setText("0");

        Button decreaseTime = (Button) findViewById(R.id.activityDecreaseTime);
        decreaseTime.setOnClickListener(view->{
            int val = Integer.parseInt(minuteView.getText().toString());
            val -= 5;
            minuteView.setText(String.valueOf(val));
        });

        Button increaseTime = (Button) findViewById(R.id.activityIncreaseTime);
        increaseTime.setOnClickListener(view->{
            int val = Integer.parseInt(minuteView.getText().toString());
            val += 5;
            minuteView.setText(String.valueOf(val));
        });

        Button submit = (Button) findViewById(R.id.activitySubmit);
        submit.setOnClickListener(view->{
            int minutes = Integer.parseInt(minuteView.getText().toString());

            //store minutes and activity info


            Intent intent1 = new Intent(view.getContext(), HomeActivity.class);
            startActivity(intent1);
        });
    }


}
