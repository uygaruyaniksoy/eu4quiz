package com.uyaniksoy.eu4quiz.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.uyaniksoy.eu4quiz.Helper.QuestionGenerator;
import com.uyaniksoy.eu4quiz.Question.FlagCountryQuestion;
import com.uyaniksoy.eu4quiz.Question.Question;
import com.uyaniksoy.eu4quiz.R;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    TextView countDown;
    TextView roundCountDown;
    AdView adView;

    TextView questionText;
    TextView score;
    ImageView imageView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button hint;
    AlphaAnimation fadeIn;

    CountDownTimer cdt;
    CountDownTimer introcdt;

    int _score = 0;
    boolean disableCountdown;
    boolean showOnWrong;
    int correctIndex;

    Question currentQuestion;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        prefs = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        editor = prefs.edit();

        disableCountdown = prefs.getBoolean("disableCountdown",false);
        showOnWrong = prefs.getBoolean("showOnWrong",false);

        countDown = (TextView) findViewById(R.id.textView2);
        questionText = (TextView) findViewById(R.id.textView3);
        roundCountDown = (TextView) findViewById(R.id.roundCountDown);
        score = (TextView) findViewById(R.id.score);
        imageView = (ImageView) findViewById(R.id.imageView);
        button1 = (Button) findViewById(R.id.button6);
        button2 = (Button) findViewById(R.id.button7);
        button3 = (Button) findViewById(R.id.button8);
        button4 = (Button) findViewById(R.id.button3);
        hint = (Button) findViewById(R.id.button4);

        score.setText(""+_score);

        fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1000);
        fadeIn.setFillAfter(true);

        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView.setVisibility(View.INVISIBLE);
        hint.setVisibility(View.INVISIBLE);

        countDown();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (cdt != null)
            cdt.cancel();
        if (introcdt != null)
            introcdt.cancel();
        finish();
    }

    public void countDown() {
        introcdt = new CountDownTimer(3000,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText(String.format("%.1f", (float) millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                countDown.setVisibility(View.INVISIBLE);
                adView.setAnimation(fadeIn);
                displayQuestion();
            }
        }.start();
    }

    public void displayQuestion() {
        int qMode = this.getSharedPreferences("data", Context.MODE_PRIVATE).getInt("questions",63);
        QuestionGenerator questionGenerator = new QuestionGenerator(this,qMode);
        currentQuestion = questionGenerator.next();
        setOptions();

        cdt = new CountDownTimer(15000,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                roundCountDown.setText(String.format("%.1f", (float) millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                roundCountDown.setText("0");
                onTimeout();
            }
        }.start();

        setButtonsEnabled(true);
        clearColorFilters();
        fadeInViews();
    }
    
    private void fadeInViews() {
        score.startAnimation(fadeIn);
        roundCountDown.startAnimation(fadeIn);
        questionText.startAnimation(fadeIn);
        button1.startAnimation(fadeIn);
        button2.startAnimation(fadeIn);
        button3.startAnimation(fadeIn);
        button4.startAnimation(fadeIn);
        hint.startAnimation(fadeIn);
        hint.setEnabled(true);
        if (currentQuestion.needsImageView())
            imageView.startAnimation(fadeIn);
        else{
            imageView.setVisibility(View.INVISIBLE);
            imageView.clearAnimation();
        }
        if (disableCountdown){
            roundCountDown.setVisibility(View.INVISIBLE);
            cdt.cancel();
        }
    }

    private void onTimeout() {
        cdt.cancel();
        score.setText(""+_score);
        setButtonsEnabled(false);
        clearColorFilters();
        Drawable next = button1.getBackground();
        next.setColorFilter(correctIndex == 0 && showOnWrong ? Color.GREEN : Color.RED, PorterDuff.Mode.MULTIPLY);
        button1.setBackground(next);
        next = button2.getBackground();
        next.setColorFilter(correctIndex == 1 && showOnWrong ? Color.GREEN : Color.RED, PorterDuff.Mode.MULTIPLY);
        button2.setBackground(next);
        next = button3.getBackground();
        next.setColorFilter(correctIndex == 2 && showOnWrong ? Color.GREEN : Color.RED, PorterDuff.Mode.MULTIPLY);
        button3.setBackground(next);
        next = button4.getBackground();
        next.setColorFilter(correctIndex == 3 && showOnWrong ? Color.GREEN : Color.RED, PorterDuff.Mode.MULTIPLY);
        button4.setBackground(next);
        CountDownTimer ctd = new CountDownTimer(1000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                toEndScreen(0);
            }
        }.start(); // call new question after 1 sec
    }

    private void toEndScreen(int cause) {
        // 0 timeout
        // 1 wrong answer
        Intent intent = new Intent(getApplicationContext(), EndActivity.class);
        intent.putExtra("cause",cause);
        intent.putExtra("score",_score);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    private void clearColorFilters() {
        button1.getBackground().clearColorFilter();
        button2.getBackground().clearColorFilter();
        button3.getBackground().clearColorFilter();
        button4.getBackground().clearColorFilter();
    }

    private void setButtonsEnabled(boolean b) {
        button1.setEnabled(b);
        button2.setEnabled(b);
        button3.setEnabled(b);
        button4.setEnabled(b);
        hint.setEnabled(b);
    }

    public void onRightAnswer(View v) {
        cdt.cancel();
        _score++;
        score.setText(""+_score);
        setButtonsEnabled(false);
        clearColorFilters();
        Drawable next = ((Button)v).getBackground();
        next.setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
        ((Button)v).setBackground(next);
        CountDownTimer ctd = new CountDownTimer(1000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                displayQuestion();
            }
        }.start(); // call new question after 1 sec
    }

    public void onWrongAnswer(View v) {
        editor.putInt(getString(R.string.rightanswers),prefs.getInt(getString(R.string.rightanswers),0)+_score).apply();
        editor.putInt(getString(R.string.wronganswers),prefs.getInt(getString(R.string.wronganswers),0)+1).apply();
        editor.putInt(getString(R.string.highscore),Math.max(prefs.getInt(getString(R.string.highscore),0),_score)).apply();
        cdt.cancel();
        score.setText(""+_score);
        setButtonsEnabled(false);
        clearColorFilters();
        Drawable next = v.getBackground();
        next.setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        v.setBackground(next);
        if (showOnWrong){
            if (correctIndex == 0)
                v = button1;
            if (correctIndex == 1)
                v = button2;
            if (correctIndex == 2)
                v = button3;
            if (correctIndex == 3)
                v = button4;
            next = v.getBackground();
            next.setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
            v.setBackground(next);
        }
        CountDownTimer ctd = new CountDownTimer(1000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                toEndScreen(1);
            }
        }.start(); // call new question after 1 sec
    }

    private void setOptions() {
        Random rand = new Random();
        correctIndex = rand.nextInt(4);

        questionText.setText(currentQuestion.getAskFor().toString());
        button1.setText(correctIndex==0 ? currentQuestion.getRightAnswer().toString() : currentQuestion.getWrongAnswers().get(0).toString());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctIndex == 0) onRightAnswer(v); else onWrongAnswer(v);
            }
        });
        button2.setText(correctIndex==1 ? currentQuestion.getRightAnswer().toString() : correctIndex == 0 ? currentQuestion.getWrongAnswers().get(0).toString() : currentQuestion.getWrongAnswers().get(1).toString());
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctIndex == 1) onRightAnswer(v); else onWrongAnswer(v);
            }
        });
        button3.setText(correctIndex==2 ? currentQuestion.getRightAnswer().toString() : correctIndex == 3 ? currentQuestion.getWrongAnswers().get(2).toString() : currentQuestion.getWrongAnswers().get(1).toString());
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctIndex == 2) onRightAnswer(v); else onWrongAnswer(v);
            }
        });
        button4.setText(correctIndex==3 ? currentQuestion.getRightAnswer().toString() : currentQuestion.getWrongAnswers().get(2).toString());
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctIndex == 3) onRightAnswer(v); else onWrongAnswer(v);
            }
        });
        if (currentQuestion.needsImageView())
            imageView.setImageResource(((FlagCountryQuestion)currentQuestion).getImageResource());
    }

    public void onHint(View view) {
        int r = correctIndex;
        while (r == correctIndex ) {
            r = new Random().nextInt(4);
        }
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        if (r == 0 || correctIndex == 0)
            button1.setEnabled(true);
        if (r == 1 || correctIndex == 1)
            button2.setEnabled(true);
        if (r == 2 || correctIndex == 2)
            button3.setEnabled(true);
        if (r == 3 || correctIndex == 3)
            button4.setEnabled(true);
        hint.setEnabled(false);
        clearColorFilters();
    }
}
