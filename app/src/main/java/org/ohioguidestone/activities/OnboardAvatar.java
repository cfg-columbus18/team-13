package org.ohioguidestone.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ohioguidestone.R;

public class OnboardAvatar extends Activity {

    public static OnboardAvatar newInstance() {
        return new OnboardAvatar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard_avatar);
    }

}
