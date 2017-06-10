package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.Age;
import com.uyaniksoy.eu4quiz.DataTypes.Ability;
import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;

import java.util.ArrayList;

public class AgeAbilityQuestion extends Question {
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
        return "Which of the following age abilities are available in " + askFor.toString();
    }

    public AgeAbilityQuestion() {

    }

    public AgeAbilityQuestion right(Ability answer) {
        rightAnswer = answer;
        return this;
    }

    public AgeAbilityQuestion wrong(Ability answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public AgeAbilityQuestion ask(String askFor) {
        this.askFor = new Age(askFor);
        return this;
    }
}
