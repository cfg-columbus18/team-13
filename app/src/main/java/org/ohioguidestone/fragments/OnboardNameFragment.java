package org.ohioguidestone.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.ohioguidestone.R;
import org.ohioguidestone.models.BundleKeys;
import org.ohioguidestone.models.UserModel;

public class OnboardNameFragment extends Fragment {
    private View fragmentView;
    private UserModel newUser;

    public static OnboardNameFragment newInstance() {
        return new OnboardNameFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.onboard_name, container, false);
        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Button continueButton = fragmentView.findViewById(R.id.onboarding_name_continue_btn);
        EditText nameField = fragmentView.findViewById(R.id.user_name);

        nameField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    continueButton.setEnabled(true);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        continueButton.setOnClickListener((view) -> {
            SharedPreferences sharedPref = this.getActivity().getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.saved_name_key), nameField.getText().toString());
            editor.commit();
            navigateToAvatarFragment();
        });
    }

    public void navigateToAvatarFragment() {
        FragmentManager manager = getActivity().getFragmentManager();
        OnboardAvatarFragment fragment = OnboardAvatarFragment.newInstance();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.onboarding_fragment_holder, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
