package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.Advisor;
import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Modifier;

import java.util.ArrayList;

public class ModifierAdvisorQuestion extends Question {
    private BaseDataType rightAnswer;
    private ArrayList<BaseDataType> wrongAnswers = new ArrayList<>();
    private BaseDataType askFor;

    public ModifierAdvisorQuestion() {

    }

    public BaseDataType getRightAnswer() {
        return rightAnswer;
    }

    public ModifierAdvisorQuestion right(Advisor answer) {
        rightAnswer = answer;
        return this;
    }

    public ModifierAdvisorQuestion wrong(Advisor answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public String getAskFor() {
        return "Which adviser has the following effect?\n" + askFor.toString();
    }

    public ArrayList<BaseDataType> getWrongAnswers() {

        return wrongAnswers;
    }

    public ModifierAdvisorQuestion ask(String answer, String value) {
        this.askFor = new Modifier(answer,value);
        return this;
    }

}
