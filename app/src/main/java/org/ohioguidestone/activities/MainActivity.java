package org.ohioguidestone.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import org.ohioguidestone.R;
import org.ohioguidestone.application.MindfulApplication;
import org.ohioguidestone.fragments.OnboardNameFragment;
import org.ohioguidestone.models.Activities;

import io.realm.Realm;

public class MainActivity extends Activity implements OnboardNameFragment.NavigateToAvatarListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//        Activities activity = realm.createObject(Activities.class);
//        activity.setName("This is very fancy");
//        activity.setDescription("Why would I ever do this ?");
//        realm.commitTransaction();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

        /*if (((MindfulApplication) this.getApplication()).getFirstStartup()) {
            FragmentManager manager = this.getFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.onboarding_fragment_holder, OnboardNameFragment.newInstance());
            transaction.commit();
        } else {

        }*/
    }


    @Override
    public void navigateToAvatarFragment() {

    }
}
