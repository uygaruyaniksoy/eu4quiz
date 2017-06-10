package com.uyaniksoy.eu4quiz.DataTypes;

public class Building extends BaseDataType{
    private String name;

    public Building(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        switch (name) {
            case "fort_15th":
                return "castle";
            case "fort_16th":
                return "bastion";
            case "fort_17th":
                return "star fort";
            case "fort_18th":
                return "fortress";
            case "wharf":
                return "naval equipment manufactory";
            case "weapons":
                return "weapons manufactory";
            case "textile":
                return "textile manufactory";
            case "plantations":
                return "plantations";
            case "tradecompany":
                return "trade station";
            default:
                return name.replace("_"," ");
        }
    }
}
