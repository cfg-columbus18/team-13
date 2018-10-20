package org.ohioguidestone.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.ohioguidestone.R;
import org.ohioguidestone.adapter.FeelingsAdapter;
import org.ohioguidestone.application.MindfulApplication;
import org.ohioguidestone.fragments.OnboardNameFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (((MindfulApplication) this.getApplication()).getFirstStartup()) {
            FragmentManager manager = this.getFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.onboarding_fragment_holder, OnboardNameFragment.newInstance());
            transaction.commit();

            enableMainLayout();
        } else {
            enableMainLayout();
        }
    }

    public void enableMainLayout() {
        TextView statusCheckText = findViewById(R.id.how_are_you_text);
        statusCheckText.setVisibility(View.VISIBLE);

        List<String> feelings = new ArrayList<>();

        feelings.add("Happy");
        feelings.add("Energetic");
        feelings.add("Hopeful");
        feelings.add("Relaxed");
        feelings.add("Nauseous");
        feelings.add("Tired");
        feelings.add("Hopeless");
        feelings.add("Brave");
        feelings.add("Calm");
        feelings.add("Anxious");
        feelings.add("Worried");
        feelings.add("Lonely");
        feelings.add("Confused");
        feelings.add("Irritable");

        RecyclerView feelingsRecyclerView = findViewById(R.id.feelings_list_view);
        FeelingsAdapter feelingsAdapter = new FeelingsAdapter(feelings);

        feelingsRecyclerView.setAdapter(feelingsAdapter);
        feelingsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
