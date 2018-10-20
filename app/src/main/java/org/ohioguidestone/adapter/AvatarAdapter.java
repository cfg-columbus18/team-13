package org.ohioguidestone.adapter;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.ohioguidestone.R;

import java.util.List;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.AvatarItemViewHolder> {

    private List<Image> avatarList;

    @Override
    @NonNull
    public AvatarItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.avatar_item, viewGroup, false);
        return new AvatarItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AvatarItemViewHolder viewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return avatarList.size();
    }

    public final static class AvatarItemViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImage;

        public AvatarItemViewHolder(View itemView) {
            super(itemView);
            avatarImage = itemView.findViewById(R.id.avatar_item_view);
        }
    }

}