package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.Age;
import com.uyaniksoy.eu4quiz.DataTypes.Ability;
import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;

import java.util.ArrayList;

public class AbilityAgeQuestion extends Question {
    private BaseDataType rightAnswer;
    private ArrayList<BaseDataType> wrongAnswers = new ArrayList<>();
    private Ability askFor;

    public BaseDataType getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<BaseDataType> getWrongAnswers() {
        return wrongAnswers;
    }

    public String getAskFor() {
        return "In which age ability " + askFor.toString() + " is available?";
    }

    public AbilityAgeQuestion right(Age answer) {
        rightAnswer = answer;
        return this;
    }

    public AbilityAgeQuestion wrong(Age answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public AbilityAgeQuestion ask(Ability askFor) {
        this.askFor = askFor;
        return this;
    }
}
