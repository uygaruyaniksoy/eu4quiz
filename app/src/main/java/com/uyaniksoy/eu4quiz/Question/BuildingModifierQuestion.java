package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Building;
import com.uyaniksoy.eu4quiz.DataTypes.Modifier;

import java.util.ArrayList;

public class BuildingModifierQuestion extends Question{
    private BaseDataType rightAnswer;
    private ArrayList<BaseDataType> wrongAnswers = new ArrayList<>();
    private Building askFor;

    public BaseDataType getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<BaseDataType> getWrongAnswers() {
        return wrongAnswers;
    }

    public String getAskFor() {
        return "What effect does " + askFor.toString() + " have on the province it has been built?";
    }

    public BuildingModifierQuestion right(Modifier answer) {
        rightAnswer = answer;
        return this;
    }

    public BuildingModifierQuestion wrong(Modifier answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public BuildingModifierQuestion ask(Building askFor) {
        this.askFor = askFor;
        return this;
    }
}
