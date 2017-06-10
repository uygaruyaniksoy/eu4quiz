package com.uyaniksoy.eu4quiz.DataTypes;

public class Idea extends BaseDataType {
    private String name;

    public Idea(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.replace("_"," ");
    }
}
