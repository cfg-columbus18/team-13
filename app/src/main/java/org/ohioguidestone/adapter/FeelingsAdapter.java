package org.ohioguidestone.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ohioguidestone.R;
import org.ohioguidestone.viewhelper.RecyclerViewClickListener;

import java.util.List;

public class FeelingsAdapter extends RecyclerView.Adapter<FeelingsAdapter.FeelingViewHolder> {

    private List<String> feelings;
    private RecyclerViewClickListener mListener;


    public FeelingsAdapter(List<String> feelings, RecyclerViewClickListener listener) {
        this.feelings = feelings;
        this.mListener = listener;

    }

    @Override
    @NonNull
    public FeelingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.feeling_item, viewGroup, false);
        return new FeelingViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FeelingViewHolder viewHolder, int position) {
        String feeling = feelings.get(position);
        viewHolder.feelingsView.setText(feeling);
    }

    @Override
    public int getItemCount() {
        return feelings.size();
    }

    public final static class FeelingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView feelingsView;
        private RecyclerViewClickListener mListener;


        public FeelingViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            feelingsView = itemView.findViewById(R.id.feelings_item_view);
            mListener = listener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }
}
