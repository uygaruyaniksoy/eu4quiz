package com.uyaniksoy.eu4quiz.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.uyaniksoy.eu4quiz.R;

public class StatisticsActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        prefs = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        ((TextView)findViewById(R.id.ra)).setText(prefs.getInt(getString(R.string.rightanswers),0)+"");
        ((TextView)findViewById(R.id.wa)).setText(prefs.getInt(getString(R.string.wronganswers),0)+"");
        ((TextView)findViewById(R.id.hs)).setText(prefs.getInt(getString(R.string.highscore),0)+"");
    }
}
