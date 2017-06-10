package com.uyaniksoy.eu4quiz.DataTypes;

public class Ability extends BaseDataType {
    private String name;

    public Ability(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        switch (name) {
            case "ab_allow_feudal_de_jure_law":
                return "Feudal De Jure Law";
            case "ab_justified_wars":
                return "Feudal De Jure Law";
            case "ab_transfer_vassal_wargoal":
                return "Transfer Subject";
            case "ab_free_war_taxes":
                return "Improved Wartaxes";
            case "ab_cavalry_armies":
                return "Cavalry Armies";
            case "ab_colony_boost_development":
                return "Higher Developed Colonies";
            case "ab_attack_bonus_in_capital_terrain":
                return "Adaptative Combat Terrain";
            case "ab_ottoman_siege_ability":
                return "The Guns of Urban";
            case "ab_portugal_colonial_growth":
                return "Portuguese Colonial Growth";
            case "ab_denmark_reduced_lib_desire":
                return "Danish Subject Loyalty";
            case "ab_venice_ship_trade":
                return "Venetian Trade";
            case "ab_allow_religion_enforced":
                return "Religion Enforced Edict";
            case "ab_siege_blockades		":
                return "Coastal Barrage";
            case "ab_warscore_vs_religion":
                return "Religious Wars";
            case "ab_mercenary_discipline":
                return "Mercenary Discipline";
            case "ab_ship_power_propagation		":
                return "Powerful Tradeships";
            case "ab_institution_spread_from_true_faith":
                return "Institutional Spread";
            case "ab_prestige_per_development_from_conversion":
                return "Prestigious Conversions\t";
            case "ab_spain_tercio":
                return "Spanish Tercios";
            case "ab_mughal_artillery":
                return "Mughal Artillery";
            case "ab_polish_legitimacy":
                return "Polish Crown";
            case "ab_persia_reinforce	":
                return "Persian Reinforcement";
            case "ab_allow_edict_of_absolutism":
                return "Edict of Absolutism";
            case "ab_rival_change":
                return "Flexible Rivalries";
            case "ab_rival_border_fort":
                return "Protecting Forts";
            case "ab_autonomy":
                return "Efficient Autonomy";
            case "ab_harsh_treatment":
                return "Harsher Treatment";
            case "ab_adm_efficiency":
                return "Administrative Efficiency";
            case "ab_yearly_absolutism":
                return "Absolute Government";
            case "ab_france_fire_damage":
                return "French Musketeers";
            case "ab_dutch_anti_corruption":
                return "Dutch Officials";
            case "ab_sweden_manpower":
                return "Swedish Recruitment";
            case "ab_manchu_banner":
                return "Manchu Banners";
            case "ab_allow_anti_revolutionary_zeal":
                return "Anti-Revolutionary Zeal";
            case "ab_napoleonic_warfare":
                return "Napoleonic Warfare";
            case "ab_force_march":
                return "Improved Force March";
            case "ab_more_ships_can_fire":
                return "Naval Engagement";
            case "ab_no_distance_for_core":
                return "Unrestricted Conquest";
            case "ab_backrow_artillery":
                return "Improved Artillery Range";
            case "ab_same_contine_lib_desire":
                return "Loyal Subjects";
            case "ab_pru_military":
                return "Prussian Discipline";
            case "ab_gbr_fleet":
                return "British Fleet";
            case "ab_russia_boost":
                return "Russian Empire";
            case "ab_austria_rep":
                return "Austrian Diplomacy";
        }
        return "";
    }
}
