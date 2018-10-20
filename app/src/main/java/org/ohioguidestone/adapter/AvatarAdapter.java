package org.ohioguidestone.adapter;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import org.ohioguidestone.R;
import org.ohioguidestone.models.Avatar;

import java.util.List;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.AvatarItemViewHolder> {

    private RecyclerViewClickListener mListener;

    private List<Avatar> avatarList;

    public AvatarAdapter(List<Avatar> avatars, RecyclerViewClickListener listener) {
        avatarList = avatars;
        mListener = listener;
    }

    @Override
    @NonNull
    public AvatarItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.avatar_item, viewGroup, false);

        return new AvatarItemViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(AvatarItemViewHolder viewHolder, int position) {
        Avatar avatar = avatarList.get(position);
        viewHolder.avatarImage.setImageDrawable(avatar.getAvatar());
    }

    @Override
    public int getItemCount() {
        return avatarList.size();
    }

    public interface RecyclerViewClickListener {

        void onClick(View view, int position);
    }

    public final static class AvatarItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RecyclerViewClickListener mListener;

        ImageView avatarImage;

        public AvatarItemViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            avatarImage = itemView.findViewById(R.id.avatar_item_view);
            mListener = listener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }


    }

}