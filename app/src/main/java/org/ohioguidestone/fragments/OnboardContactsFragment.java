package org.ohioguidestone.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ohioguidestone.R;
import org.ohioguidestone.fragments.OnboardAvatarFragment;

public class OnboardContactsFragment extends Fragment {
    private View fragmentView;

    public static OnboardContactsFragment newInstance() {
        return new OnboardContactsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.onboard_contacts, container, false);
        return fragmentView;
    }
}
