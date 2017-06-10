package com.uyaniksoy.eu4quiz.DataTypes;

public class PrimaryCulture extends BaseDataType {
    private String name;

    public PrimaryCulture(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.replace("_"," ");
    }
}
