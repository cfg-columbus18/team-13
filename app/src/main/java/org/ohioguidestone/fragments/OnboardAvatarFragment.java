package org.ohioguidestone.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import org.ohioguidestone.R;
import org.ohioguidestone.activities.MainActivity;
import org.ohioguidestone.adapter.AvatarAdapter;
import org.ohioguidestone.models.Avatar;
import org.ohioguidestone.models.UserModel;
import org.ohioguidestone.viewhelper.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class OnboardAvatarFragment extends Fragment {
    private View fragmentView;
    private UserModel newUser;
    private int currentAvatar = R.drawable.ic_001_dog;
    private int[] avatarData = new int[] {
            R.drawable.ic_001_dog,
            R.drawable.ic_002_bird,
            R.drawable.ic_003_fish,
            R.drawable.ic_004_butterfly,
            R.drawable.ic_005_summer,
            R.drawable.ic_006_stag,
            R.drawable.ic_007_cat,
            R.drawable.ic_008_zoo,
            R.drawable.ic_009_pig,
            R.drawable.ic_010_bee,
            R.drawable.ic_011_unicorn,
            R.drawable.ic_012_lion,
            R.drawable.ic_013_rabbit,
            R.drawable.ic_014_goat,
            R.drawable.ic_015_owl,
            R.drawable.ic_016_fox };

    public static OnboardAvatarFragment newInstance() {
        return new OnboardAvatarFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.onboard_avatar, container, false);
        List<Avatar> avatars = initializeAvatars();

        RecyclerView avatarView = fragmentView.findViewById(R.id.avatar_selection_view);
        avatarView.addItemDecoration(new SpacesItemDecoration(10));
        AvatarAdapter avatarAdapter = new AvatarAdapter(avatars, ((view, position) -> {
            ImageView icon = (ImageView) fragmentView.findViewById(R.id.selected_avatar);
            icon.setImageResource(avatarData[position]);
        }));

        avatarView.setAdapter(avatarAdapter);
        avatarView.setLayoutManager(new GridLayoutManager(getActivity(), 4));

//        newUser = (UserModel) savedInstanceState.getSerializable(BundleKeys.USER_DATA_BUNDLE_KEY);

        return fragmentView;
    }

    private List<Avatar> initializeAvatars() {
        List<Avatar> avatars = new ArrayList<>();

        for(int iconValue: avatarData) {
            avatars.add(new Avatar(getActivity().getResources().getDrawable(iconValue)));
        }

        return avatars;
    }

    @Override
    public void onResume() {
        super.onResume();

        Button continueButton = fragmentView.findViewById(R.id.onboarding_avatar_continue_btn);
        continueButton.setOnClickListener((view) -> {
            FragmentManager manager = getActivity().getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            SharedPreferences sharedPref = this.getActivity().getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.saved_avatar_key), getResources().getResourceEntryName(currentAvatar));
            editor.putBoolean(getString(R.string.saved_user_created_key), true);
            editor.commit();
            transaction.remove(this);
            transaction.commit();
            ((MainActivity) getActivity()).enableMainLayout();

        });
    }



}
