package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Country;
import com.uyaniksoy.eu4quiz.DataTypes.Government;

import java.util.ArrayList;

public class CountryGovernmentQuestion extends Question {
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
        return "What government type does " + askFor.toString() + " have?";
    }

    public CountryGovernmentQuestion right(Government answer) {
        rightAnswer = answer;
        return this;
    }

    public CountryGovernmentQuestion wrong(Government answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public CountryGovernmentQuestion ask(Country askFor) {
        this.askFor = askFor;
        return this;
    }
}
