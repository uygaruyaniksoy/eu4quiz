package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.Advisor;
import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Idea;
import com.uyaniksoy.eu4quiz.DataTypes.Modifier;

import java.util.ArrayList;

public class IdeaModifierQuestion extends Question {
    private BaseDataType rightAnswer;
    private ArrayList<BaseDataType> wrongAnswers = new ArrayList<>();
    private Idea askFor;

    public BaseDataType getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<BaseDataType> getWrongAnswers() {
        return wrongAnswers;
    }

    public IdeaModifierQuestion() {
    }

    public String getAskFor() {
        return "Which of the following bonus is provided by " + askFor.toString() + "?";
    }

    public IdeaModifierQuestion right(Modifier answer) {
        rightAnswer = answer;
        return this;
    }

    public IdeaModifierQuestion wrong(Modifier answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public IdeaModifierQuestion ask(Idea askFor) {
        this.askFor = askFor;
        return this;
    }
}
