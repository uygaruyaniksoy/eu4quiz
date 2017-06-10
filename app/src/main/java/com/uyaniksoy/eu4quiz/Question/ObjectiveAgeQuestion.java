package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.Age;
import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Objective;

import java.util.ArrayList;

public class ObjectiveAgeQuestion extends Question {
    private BaseDataType rightAnswer;
    private ArrayList<BaseDataType> wrongAnswers = new ArrayList<>();
    private BaseDataType askFor;

    public BaseDataType getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<BaseDataType> getWrongAnswers() {
        return wrongAnswers;
    }

    public String getAskFor() {
        return "In which age objective " + askFor.toString() + " is available?";
    }

    public ObjectiveAgeQuestion() {

    }

    public ObjectiveAgeQuestion right(Age answer) {
        rightAnswer = answer;
        return this;
    }

    public ObjectiveAgeQuestion wrong(Age answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public ObjectiveAgeQuestion ask(Objective askFor) {
        this.askFor = askFor;
        return this;
    }
}
