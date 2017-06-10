package com.uyaniksoy.eu4quiz.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.uyaniksoy.eu4quiz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPlayClicked(View view) {
        Intent intent = new Intent(getApplicationContext(),PlayActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    public void onStatisticsClicked(View view) {
        startActivity(new Intent(getApplicationContext(),StatisticsActivity.class));
    }

    public void onOptionsClicked(View view) {
        startActivity(new Intent(getApplicationContext(),OptionsActivity.class));
    }
}
