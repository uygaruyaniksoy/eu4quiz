package com.uyaniksoy.eu4quiz.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import com.uyaniksoy.eu4quiz.R;

public class OptionsActivity extends AppCompatActivity {
    private String[] options = {"Age", "Building", "Country", "Flag", "Adviser", "Idea Groups"};
    private ListView listView;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        prefs = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        editor = prefs.edit();

        int q = prefs.getInt("questions",63);
        boolean disableCountdown = prefs.getBoolean("disableCountdown",false);
        boolean showOnWrong = prefs.getBoolean("showOnWrong",false);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_multiple_choice, options);
        listView = ((ListView) findViewById(R.id.listView));
        listView.setAdapter(adapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setItemsCanFocus(false);
        for (int i = 0,m=1; i < options.length; i++,m*=2) {
            listView.setItemChecked(i,0 != (q & m));
        }
        ((CheckBox) findViewById(R.id.checkBox)).setChecked(disableCountdown);
        ((CheckBox) findViewById(R.id.checkBox2)).setChecked(showOnWrong);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SparseBooleanArray sparseBooleanArray = listView.getCheckedItemPositions();
        boolean d = ((CheckBox) findViewById(R.id.checkBox)).isChecked();
        boolean s = ((CheckBox) findViewById(R.id.checkBox2)).isChecked();

        int q=0;
        for (int i = 0,m=1; i < options.length; i++,m*=2) {
            if(sparseBooleanArray.get(i))
                q+=m;
        }

        editor.putInt("questions",q).apply();
        editor.putBoolean("disableCountdown",d).apply();
        editor.putBoolean("showOnWrong",s).apply();
    }
}
