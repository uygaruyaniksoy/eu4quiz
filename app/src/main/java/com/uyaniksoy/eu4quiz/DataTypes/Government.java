package com.uyaniksoy.eu4quiz.DataTypes;

public class Government extends BaseDataType {
    private String name;

    public Government(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.replace("_"," ");
    }
}
