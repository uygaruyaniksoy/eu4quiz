package com.uyaniksoy.eu4quiz.DataTypes;

public class Age extends BaseDataType {
    private String name;

    public Age(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.replace("_"," ");
    }
}
