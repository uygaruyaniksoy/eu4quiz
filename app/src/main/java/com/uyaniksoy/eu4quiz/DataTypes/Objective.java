package com.uyaniksoy.eu4quiz.DataTypes;

public class Objective extends BaseDataType {
    private String name;

    public Objective(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        switch (name) {
            case "obj_discover_america":
                return "Discover America";
            case "obj_100_development":
                return "Developed Nation";
            case "obj_5_centers_of_trade":
                return "Control Centers of Trade";
            case "obj_30_development_city":
                return "A Large City";
            case "obj_renaissance":
                return "Embrace Renaissance";
            case "obj_two_unions":
                return "Hold Three Thrones";
            case "obj_many_vassals":
                return "Feudal Society";
            case "obj_two_continents":
                return "Present on Two Continents";
            case "obj_humiliate_rival":
                return "Humiliate Rival";
            case "obj_christian_convert":
                return "Join the Reformation";
            case "obj_humanism_religious":
                return "Humanist or Religious";
            case "obj_convert_10_provinces":
                return "Convert Provinces";
            case "obj_colonial_empire":
                return "Create a Colonial Empire";
            case "obj_force_converted":
                return "Converted another Nation";
            case "obj_asian_trade":
                return "Asian Trade";
            case "obj_unify_culture":
                return "Unify Culture";
            case "obj_3_trade_companies":
                return "Three Trade Companies";
            case "obj_universities":
                return "Multiple Universities";
            case "obj_large_forcelimit":
                return "Potential for a Large Army";
            case "obj_90_absolutism":
                return "Absolutism";
            case "obj_emperor_of_china":
                return "Emperor of China";
            case "obj_cultures_accepted":
                return "Multicultural Nation";
            case "obj_win_religious_war":
                return "Win Religious War";
            case "obj_parliament":
                return "Parliament";
            case "obj_emperor":
                return "Emperor";
            case "obj_large_subject":
                return "Powerful Subject";
            case "obj_disc_army":
                return "High Discipline";
            case "obj_huge_capital":
                return "Large Capital";
            case "obj_great_general":
                return "Great Leader";
            case "obj_two_institutions":
                return "Control Institutions";
        }
        return "";
    }



}
