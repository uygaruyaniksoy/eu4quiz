package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Country;
import com.uyaniksoy.eu4quiz.DataTypes.Government;
import com.uyaniksoy.eu4quiz.DataTypes.Religion;

import java.util.ArrayList;

public class CountryReligionQuestion extends Question {
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
        return "What religion does " + askFor.toString() + " have?";
    }

    public CountryReligionQuestion right(Religion answer) {
        rightAnswer = answer;
        return this;
    }

    public CountryReligionQuestion wrong(Religion answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public CountryReligionQuestion ask(Country askFor) {
        this.askFor = askFor;
        return this;
    }
}
