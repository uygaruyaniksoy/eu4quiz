package com.uyaniksoy.eu4quiz.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.uyaniksoy.eu4quiz.R;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Intent intent = getIntent();
        String endText = "Game Over!";
        ((TextView) findViewById(R.id.endText)).setText(endText);
        ((TextView) findViewById(R.id.end_score)).setText(intent.getIntExtra("score",0)+"");
    }

    public void onMainMenuClicked(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
    }

    public void onReplayClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
