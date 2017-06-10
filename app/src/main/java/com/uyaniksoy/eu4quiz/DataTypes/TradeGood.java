package com.uyaniksoy.eu4quiz.DataTypes;

public class TradeGood extends BaseDataType{
    private String name;

    public TradeGood(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.replace("_"," ");
    }
}
