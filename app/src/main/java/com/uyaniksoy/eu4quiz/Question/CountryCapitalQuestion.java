package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Capital;
import com.uyaniksoy.eu4quiz.DataTypes.Country;
import com.uyaniksoy.eu4quiz.DataTypes.Religion;

import java.util.ArrayList;

public class CountryCapitalQuestion extends Question {
    private BaseDataType rightAnswer;
    private ArrayList<BaseDataType> wrongAnswers = new ArrayList<>();
    private Country askFor;

    public BaseDataType getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<BaseDataType> getWrongAnswers() {
        return wrongAnswers;
    }

    public String getAskFor() {
        return "Which province is the capital of " + askFor.toString() + "?";
    }

    public CountryCapitalQuestion right(Capital answer) {
        rightAnswer = answer;
        return this;
    }

    public CountryCapitalQuestion wrong(Capital answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public CountryCapitalQuestion ask(Country askFor) {
        this.askFor = askFor;
        return this;
    }
}
