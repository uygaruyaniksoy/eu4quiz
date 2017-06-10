package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Country;
import com.uyaniksoy.eu4quiz.DataTypes.PrimaryCulture;

import java.util.ArrayList;

public class CountryPrimaryCultureQuestion extends Question {
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
        return "What culture does " + askFor.toString() + " have?";
    }

    public CountryPrimaryCultureQuestion right(PrimaryCulture answer) {
        rightAnswer = answer;
        return this;
    }

    public CountryPrimaryCultureQuestion wrong(PrimaryCulture answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public CountryPrimaryCultureQuestion ask(Country askFor) {
        this.askFor = askFor;
        return this;
    }
}
