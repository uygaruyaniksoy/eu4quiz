package com.uyaniksoy.eu4quiz.DataTypes;

public class Country extends BaseDataType {
    private String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.replace("_"," ");
    }
}
