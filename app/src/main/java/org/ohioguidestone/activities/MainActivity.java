package org.ohioguidestone.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.ohioguidestone.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);*/
    }
}
