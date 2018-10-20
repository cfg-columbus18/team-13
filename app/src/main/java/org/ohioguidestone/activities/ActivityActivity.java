package org.ohioguidestone.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.ohioguidestone.R;
import org.w3c.dom.Text;

public class ActivityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        //Get info from intent for the activity

        ImageView heartImage = (ImageView) findViewById(R.id.activityHeart);
        heartImage.setOnClickListener(view->{
            //database backend note that they liked it
        });

        TextView title = (TextView) findViewById(R.id.activityTitle);
        title.setText(""); //set title based on data from intent

        ImageView image = (ImageView) findViewById(R.id.activityImage);
        //image.setImageBitmap();
        //or
        //image.setImageDrawable();

        TextView description = (TextView) findViewById(R.id.activityDescription);
        description.setText(""); //set description based on data from intent

        TextView minuteView = (TextView) findViewById(R.id.activityCompletedTime);
        minuteView.setText("0");

        Button decreaseTime = (Button) findViewById(R.id.activityDecreaseTime);
        decreaseTime.setOnClickListener(view->{
            int val = Integer.parseInt(minuteView.getText().toString());
            val -= 5;
            minuteView.setText(val);
        });

        Button increaseTime = (Button) findViewById(R.id.activityIncreaseTime);
        increaseTime.setOnClickListener(view->{
            int val = Integer.parseInt(minuteView.getText().toString());
            val += 5;
            minuteView.setText(val);
        });

        Button submit = (Button) findViewById(R.id.activitySubmit);
        submit.setOnClickListener(view->{
            int minutes = Integer.parseInt(minuteView.getText().toString());

            //store minutes and activity info
        });
    }


}
