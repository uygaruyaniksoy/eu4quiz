package com.uyaniksoy.eu4quiz.DataTypes;

public class Religion extends BaseDataType {
    private String name;

    public Religion(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        switch (name){
            case "tengri_pagan_reformed":
            case "secondary_vajrayana":
            case "secondary_confucianism":
                return "tengri";
            case "add_harmonized_mahayana":
                return "confucian";
            case "mesoamerican_religion":
                return "mayan";
            default:
                return name.replace("_"," ");
        }
    }
}
