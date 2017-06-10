package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.Advisor;
import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Modifier;

import java.util.ArrayList;

public class AdvisorModifierQuestion extends Question {
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
        return "Which effect does " + askFor.toString() + " advisor provide?";
    }

    public AdvisorModifierQuestion() {

    }

    public AdvisorModifierQuestion right(String answer, String value) {
        rightAnswer = new Modifier(answer,value);
        return this;
    }

    public AdvisorModifierQuestion wrong(String answer, String value) {
        wrongAnswers.add(new Modifier(answer,value));
        return this;
    }

    public AdvisorModifierQuestion ask(String askFor) {
        this.askFor = new Advisor(askFor);
        return this;
    }
}
