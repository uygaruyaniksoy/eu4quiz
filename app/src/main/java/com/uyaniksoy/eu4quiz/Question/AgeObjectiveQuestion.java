package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.Age;
import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Objective;

import java.util.ArrayList;

public class AgeObjectiveQuestion extends Question {
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
        return "Which of the following age objectives are available in " + askFor.toString();
    }

    public AgeObjectiveQuestion() {

    }

    public AgeObjectiveQuestion right(Objective answer) {
        rightAnswer = answer;
        return this;
    }

    public AgeObjectiveQuestion wrong(Objective answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public AgeObjectiveQuestion ask(String askFor) {
        this.askFor = new Age(askFor);
        return this;
    }
}
