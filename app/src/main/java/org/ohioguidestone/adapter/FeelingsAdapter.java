package org.ohioguidestone.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ohioguidestone.R;

import java.util.List;

public class FeelingsAdapter extends RecyclerView.Adapter<FeelingsAdapter.FeelingViewHolder> {

    private List<String> feelings;

    public FeelingsAdapter(List<String> feelings) {
        this.feelings = feelings;
    }

    @Override
    @NonNull
    public FeelingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.feeling_item, viewGroup, false);
        return new FeelingViewHolder(itemView);
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

    public final static class FeelingViewHolder extends RecyclerView.ViewHolder {
        TextView feelingsView;

        public FeelingViewHolder(View itemView) {
            super(itemView);
            feelingsView = itemView.findViewById(R.id.feelings_item_view);
        }
    }
}
