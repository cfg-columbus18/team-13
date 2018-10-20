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

import java.util.ArrayList;
import java.util.List;

public class OnboardAvatarFragment extends Fragment {
    private View fragmentView;

    public static OnboardAvatarFragment newInstance() {
        return new OnboardAvatarFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.onboard_avatar, container, false);
        List<Avatar> avatars = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            avatars.add(new Avatar(getActivity().getResources().getDrawable(R.drawable.ic_001_dog)));
        }

        RecyclerView avatarView = fragmentView.findViewById(R.id.avatar_selection_view);
        AvatarAdapter avatarAdapter = new AvatarAdapter(avatars);

        avatarView.setAdapter(avatarAdapter);
        avatarView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        return fragmentView;
    }

}
