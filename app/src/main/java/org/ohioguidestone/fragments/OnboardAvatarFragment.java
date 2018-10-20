package org.ohioguidestone.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ohioguidestone.R;
import org.ohioguidestone.adapter.AvatarAdapter;
import org.ohioguidestone.models.Avatar;
import org.ohioguidestone.models.BundleKeys;
import org.ohioguidestone.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class OnboardAvatarFragment extends Fragment {
    private View fragmentView;
    private UserModel newUser;

    public static OnboardAvatarFragment newInstance() {
        return new OnboardAvatarFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.onboard_avatar, container, false);
        List<Avatar> avatars = initializeAvatars();

        RecyclerView avatarView = fragmentView.findViewById(R.id.avatar_selection_view);
        AvatarAdapter avatarAdapter = new AvatarAdapter(avatars);

        avatarView.setAdapter(avatarAdapter);
        avatarView.setLayoutManager(new GridLayoutManager(getActivity(), 5));

        newUser = (UserModel) savedInstanceState.getSerializable(BundleKeys.USER_DATA_BUNDLE_KEY);

        return fragmentView;
    }

    private List<Avatar> initializeAvatars() {
        List<Avatar> avatars = new ArrayList<>();

        // I'm sorry this is ugly as sin
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_001_dog)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_002_bird)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_004_butterfly)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_005_summer)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_006_stag)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_007_cat)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_008_zoo)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_009_pig)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_010_bee)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_011_unicorn)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_012_lion)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_013_rabbit)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_014_goat)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_015_owl)));
        avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_016_fox)));

        return avatars;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

}
