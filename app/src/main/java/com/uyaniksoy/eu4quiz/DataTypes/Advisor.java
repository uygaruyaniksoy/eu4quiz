package com.uyaniksoy.eu4quiz.DataTypes;

public class Advisor extends BaseDataType {
    private String name;

    public Advisor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.replace("_"," ");
    }
}
