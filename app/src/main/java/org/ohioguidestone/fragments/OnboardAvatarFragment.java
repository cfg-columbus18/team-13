package org.ohioguidestone.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ohioguidestone.R;

public class OnboardAvatarFragment extends Fragment {
    private View fragmentView;

    public static OnboardAvatarFragment newInstance() {
        return new OnboardAvatarFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.onboard_avatar, container);
        return fragmentView;
    }
}
