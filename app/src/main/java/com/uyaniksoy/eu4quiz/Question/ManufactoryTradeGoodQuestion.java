package com.uyaniksoy.eu4quiz.Question;

import com.uyaniksoy.eu4quiz.DataTypes.BaseDataType;
import com.uyaniksoy.eu4quiz.DataTypes.Building;
import com.uyaniksoy.eu4quiz.DataTypes.TradeGood;

import java.util.ArrayList;

public class ManufactoryTradeGoodQuestion extends Question{
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
        return "Which trade good should a province have in order to build a " + askFor.toString();
    }

    public ManufactoryTradeGoodQuestion right(TradeGood answer) {
        rightAnswer = answer;
        return this;
    }

    public ManufactoryTradeGoodQuestion wrong(TradeGood answer) {
        wrongAnswers.add(answer);
        return this;
    }

    public ManufactoryTradeGoodQuestion ask(Building askFor) {
        this.askFor = askFor;
        return this;
    }
}
