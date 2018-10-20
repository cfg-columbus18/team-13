package org.ohioguidestone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.ohioguidestone.R;
import org.ohioguidestone.models.Activities;
import org.ohioguidestone.models.Category;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        EditText name = findViewById(R.id.createActivityName);
        EditText description = findViewById(R.id.createActivityDescription);
        Button submit = findViewById(R.id.createActivitySubmit);
        Spinner category = findViewById(R.id.createActivityCategory);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Category> categories = realm.where(Category.class).findAll();
        String[] items = new String[categories.size()];
        for(int i = 0; i < categories.size(); i++){
            items[i] = categories.get(i).getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        category.setAdapter(adapter);
        submit.setOnClickListener(view->{
            Activities activity = new Activities();
            activity.setName(name.getText().toString());
            activity.setDescription(description.getText().toString());
            RealmQuery<Category> temp = realm.where(Category.class).contains("name", category.getSelectedItem().toString());
            activity.setCategory(temp.findFirst());
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }

}
