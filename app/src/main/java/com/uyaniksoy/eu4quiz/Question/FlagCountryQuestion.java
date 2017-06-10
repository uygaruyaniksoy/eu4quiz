package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Capital;
import com.uyaniksoy.eu4quiz.DataTypes.Country;

import java.util.ArrayList;

public class FlagCountryQuestion extends Question {
    private BaseDataType rightAnswer;
    private ArrayList<BaseDataType> wrongAnswers = new ArrayList<>();
    private int askFor;

    public BaseDataType getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<BaseDataType> getWrongAnswers() {
        return wrongAnswers;
    }

    public String getAskFor() {
        return "Which country does the flag belong to?";
    }

    public FlagCountryQuestion right(Country answer) {
        rightAnswer = answer;
        return this;
    }

    public FlagCountryQuestion wrong(Country answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public FlagCountryQuestion ask(int askFor) {
        this.askFor = askFor;
        return this;
    }

    public int getImageResource() {
        return askFor;
    }

    public boolean needsImageView() {
        return true;
    }
}
