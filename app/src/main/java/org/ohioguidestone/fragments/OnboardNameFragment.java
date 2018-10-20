package org.ohioguidestone.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ohioguidestone.R;
import org.ohioguidestone.fragments.OnboardAvatarFragment;

public class OnboardNameFragment extends Fragment {
    private View fragmentView;

    public static OnboardNameFragment newInstance() {
        return new OnboardNameFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.onboard_name, container, false);
        return fragmentView;
    }
}
