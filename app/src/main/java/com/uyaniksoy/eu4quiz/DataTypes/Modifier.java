package com.uyaniksoy.eu4quiz.DataTypes;

public class Modifier extends BaseDataType {
    private String name;
    private String value;
    private float _value;

    public Modifier(String name, String value) {
        this.name = name;
        this.value = value;
        if (!value.equals("yes"))
            _value = Float.valueOf(value);
    }

    @Override
    public String toString() {
        switch (name) {
            // advisor
            case "prestige":
                return "Yearly prestige by "+value + "%";
            case "production_efficiency":
                return "Production efficiency by "+((int)(_value*100)) + "%";
            case "stability_cost_modifier":
                return "Stability cost by "+((int)(_value*100)) + "%";
            case "global_tax_modifier":
                return "Global tax by "+((int)(_value*100)) + "%";
            case "global_unrest":
                return "Global unrest by "+value;
            case "inflation_reduction":
                return "Yearly inflation reduction by "+_value;
            case "global_missionary_strength":
                return "Global missionary strength by "+((int)(_value*100)) + "%";
            case "diplomatic_reputation":
                return "Diplomatic reputation by "+value;
            case "naval_morale":
                return "Naval morale by "+((int)(_value*100)) + "%";
            case "trade_efficiency":
                return "Trade efficiency by "+((int)(_value*100)) + "%";
            case "spy_offence":
                return "Spy network construction speed by "+((int)(_value*100)) + "%";
            case "global_tariffs":
                return "Global tariffs by "+((int)(_value*100)) + "%";
            case "improve_relation_modifier":
                return "Improve relation by "+((int)(_value*100)) + "%";
            case "range":
                return "Colonial range by "+((int)(_value*100)) + "%";
            case "land_morale":
                return "Land morale by "+((int)(_value*100)) + "%";
            case "land_forcelimit_modifier":
                return "Land forcelimit by "+((int)(_value*100)) + "%";
            case "discipline":
                return "Discipline by "+((int)(_value*100)) + "%";
            case "reinforce_speed":
                return "Reinforce speed by "+((int)(_value*100)) + "%";
            case "global_manpower_modifier":
                return "Global manpower by "+((int)(_value*100)) + "%";
            case "defensiveness":
                return "Defensiveness by "+((int)(_value*100)) + "%";
            case "land_maintenance_modifier":
                return "Land maintenance by "+((int)(_value*100)) + "%";
            //building
            case "province_trade_power_modifier":
                return "Provincal trade power by "+((int)(_value*100)) + "%";
            case "local_production_efficiency":
                return "Local production efficiency by "+((int)(_value*100)) + "%";
            case "local_tax_modifier":
                return "Local tax modifier by "+((int)(_value*100)) + "%";
            case "local_manpower_modifier":
                return "Local manpower by "+((int)(_value*100)) + "%";
            case "naval_forcelimit":
                return "Naval forcelimit by "+value;
            case "fort_level":
                return "Fort level by "+value;
            case "local_state_maintenance_modifier":
                return "Local state maintenance by "+((int)(_value*100)) + "%";
            case "local_sailors_modifier":
                return "Local sailors by "+((int)(_value*100)) + "%";
            case "land_forcelimit":
                return "Land forcelimit by "+value;
            case "local_missionary_strength":
                return "Local missionary strangth by "+((int)(_value*100)) + "%";
            case "local_development_cost":
                return "Local development cost by "+((int)(_value*100)) + "%";
            case "cavalry_power":
                return "Cavalary power by "+((int)(_value*100)) + "%";
            case "cavalry_cost":
                return "Cavalary cost by "+((int)(_value*100)) + "%";
            case "enemy_core_creation":
                return "Enemy core creation by "+((int)(_value*100)) + "%";
            case "vassal_income":
                return "Vassal Income by "+((int)(_value*100)) + "%";
            case "army_tradition_decay":
                return "Army tradition decay by "+((int)(_value*100)) + "%";
            case "navy_tradition_decay":
                return "Navy tradition decay by "+((int)(_value*100)) + "%";
            case "mil_tech_cost_modifier ":
                return "Military technology cost by "+((int)(_value*100)) + "%";
            case "global_institution_spread":
                return "Global institution spread by "+((int)(_value*100)) + "%";
            case "global_trade_goods_size_modifier":
                return "Global trade goods by "+((int)(_value*100)) + "%";
            case "caravan_power":
                return "Caravan power by "+((int)(_value*100)) + "%";
            case "advisor_cost":
                return "Advisor cost by "+((int)(_value*100)) + "%";
            case "prestige_decay":
                return "Prestige decay by "+((int)(_value*100)) + "%";
            case "technology_cost":
                return "Technology cost by "+((int)(_value*100)) + "%";
            case "embracement_cost":
                return "Embracement cost by "+((int)(_value*100)) + "%";
            case "inflation_action_cost":
                return "Reduce Inflation cost by "+((int)(_value*100)) + "%";
            case "war_exhaustion":
                return "War exhaustion by "+value;
            case "free_leader_pool":
                return "Free leader upkeep +"+value;
            case "culture_conversion_cost":
                return "Culture conversion cost by "+((int)(_value*100)) + "%";
            case "missionaries":
                return "Missionary +"+value;
            case "tolerance_own":
                return "Tolerance of True Faith by "+value;
            case "papal_influence":
                return "Papal influence by "+value;
            case "devotion":
                return "Yearly Devotion by "+value;
            case "monthly_fervor_increase":
                return "Monthly fervor increase by "+value;
            case "church_power_modifier":
                return "Church power by "+((int)(_value*100)) + "%";
            case "global_heretic_missionary_strength":
                return "Heretic missionary strength by "+((int)(_value*100)) + "%";
            case "cb_on_religious_enemies":
                return "Casus Belli against other religions";
            case "rebel_support_efficiency":
                return "Rebel support efficiency by "+((int)(_value*100)) + "%";
            case "global_spy_defence":
                return "Global spy defence by "+((int)(_value*100)) + "%";
            case "global_prov_trade_power_modifier":
                return "Global province trade power by "+((int)(_value*100)) + "%";
            case "reduced_liberty_desire":
                return "Liberty desire of subjects by "+((int)(_value*100)) + "%";
            case "fabricate_claims_cost":
                return "Fabricate claim cost by "+((int)(_value*100)) + "%";
            case "embargo_efficiency":
                return "embargo efficiency by "+((int)(_value*100)) + "%";
            case "privateer_efficiency":
                return "privateer efficiency by "+((int)(_value*100)) + "%";
            case "yearly_corruption":
                return "yearly corruption by"+value;
            case "reduced_stab_impacts":
                return "reduced stability effects from diplomatic actions";
            case "diplomats":
                return "diplomats by "+value;
            case "war_exhaustion_cost":
                return "reduce war exhaustion cost by "+((int)(_value*100)) + "%";
            case "province_warscore_cost":
                return "province warscore cost by "+((int)(_value*100)) + "%";
            case "dip_tech_cost_modifier":
                return "diplomatic technology cost by "+((int)(_value*100)) + "%";
            case "recover_army_morale_speed":
                return "recover army morale speed by "+((int)(_value*100)) + "%";
            case "leader_land_shock":
                return "leader land shock by "+value;
            case "leader_land_fire":
                return "leader land fire by "+value;
            case "prestige_from_land":
                return "prestige from land battle by "+((int)(_value*100)) + "%";
            case "siege_ability":
                return "siege ability by "+((int)(_value*100)) + "%";
            case "hostile_attrition":
                return "hostile attrition by "+((int)(_value*100)) + "%";
            case "leader_land_manuever":
                return "leader land manuever by "+value;
            case "fort_maintenance_modifier":
                return "fort maintenance modifier by "+((int)(_value*100)) + "%";
            case "land_attrition":
                return "land attrition by "+((int)(_value*100)) + "%";
            case "trade_range_modifier":
                return "trade range modifier by "+((int)(_value*100)) + "%";
            case "merchants":
                return "merchants +"+value;
            case "trade_steering":
                return "trade steering by "+((int)(_value*100)) + "%";
            case "development_cost":
                return "development cost by "+((int)(_value*100)) + "%";
            case "build_cost":
                return "build cost by "+((int)(_value*100)) + "%";
            case "interest":
                return "interest per annum by "+value;
            case "global_autonomy":
                return "global autonomy by "+((int)(_value*100)) + "%";
            case "cb_on_primitives":
                return "casus belli on primitives";
            case "colonists":
                return "colonists by "+value;
            case "may_explore":
                return "can explore";
            case "global_colonial_growth":
                return "global colonial growth by "+_value;
            case "sea_repair":
                return "can repair at sea";
            case "navy_tradition":
                return "navy tradition by "+((int)(_value*100)) + "%";
            case "global_sailors_modifier":
                return "global sailors modifier by "+((int)(_value*100)) + "%";
            case "global_ship_repair":
                return "global ship repair by "+((int)(_value*100)) + "%";
            case "sailor_maintenance_modifer":
                return "navy maintenance by "+((int)(_value*100)) + "%";
            case "naval_forcelimit_modifier":
                return "naval forcelimit by "+((int)(_value*100)) + "%";
            case "global_ship_cost":
                return "global ship cost by"+((int)(_value*100)) + "%";
            case "leader_naval_manuever":
                return "leader naval manuever by "+value;
            case "blockade_efficiency":
                return "blockade efficiency by "+((int)(_value*100)) + "%";
            case "infantry_power":
                return "infantry power by "+((int)(_value*100)) + "%";
            case "army_tradition":
                return "army tradition by "+((int)(_value*100)) + "%";
            case "naval_attrition":
                return "naval attrition by "+((int)(_value*100)) + "%";
            case "artillery_power":
                return "artillery power by "+((int)(_value*100)) + "%";
            case "land_forcelimit_modifier ":
                return "land forcelimit modifier by "+((int)(_value*100)) + "%";
            case "manpower_recovery_speed":
                return "manpower recovery speed by "+((int)(_value*100)) + "%";
            case "global_regiment_cost":
                return "global regiment cost by "+((int)(_value*100)) + "%";
            case "possible_mercenaries":
                return "possible mercenaries by "+((int)(_value*100)) + "%";
            case "garrison_size":
                return "garrison size by "+((int)(_value*100)) + "%";
            case "cb_on_overseas":
                return "can fabricate on overseas";
            case "state_maintenance_modifier":
                return "state maintenance modifier by "+((int)(_value*100)) + "%";
            case "global_regiment_recruit_speed":
                return "global regiment recruit speed by "+((int)(_value*100)) + "%";
            case "global_ship_recruit_speed":
                return "global ship recruit speed by "+((int)(_value*100)) + "%";
            case "global_trade_power":
                return "global trade power by "+((int)(_value*100)) + "%";
            case "max_states":
                return "max states by "+_value;
            case "mercenary_cost":
                return "mercenary cost by "+((int)(_value*100)) + "%";
            case "core_creation":
                return "core creation by "+((int)(_value*100)) + "%";
            case "merc_maintenance_modifier":
                return "mercenary maintenance by "+((int)(_value*100)) + "%";
            case "advisor_pool":
                return "extra advisors by "+value;
            case "adm_tech_cost_modifier":
                return "administrative technology cost by "+((int)(_value*100)) + "%";
            case "idea_cost":
                return "idea cost by "+((int)(_value*100)) + "%";
            case "yearly_harmony":
                return "yearly harmony by "+((int)(_value*100)) + "%";
            case "religious_unity":
                return "religious unity by "+((int)(_value*100)) + "%";
            case "tolerance_heretic":
                return "tolerance of heretic by "+value;
            case "years_of_nationalism":
                return "years of nationalism by"+value;
            case "num_accepted_cultures":
                return "number of accepted cultures"+value;
            case "tolerance_heathen":
                return "tolerance of heathen"+value;
            case "unjustified_demands":
                return "unjustified demands by "+((int)(_value*100)) + "%";
            case "heir_chance":
                return "new heir chance by "+((int)(_value*100)) + "%";
            case "diplomatic_annexation_cost":
                return "diplomatic annexation cost by "+((int)(_value*100)) + "%";
            case "ae_impact":
                return "aggressive expansion by "+((int)(_value*100)) + "%";
            case "envoy_travel_time":
                return "envoy travel time by "+((int)(_value*100)) + "%";
            case "diplomatic_upkeep":
                return "diplomatic relations by"+value;
            case "vassal_forcelimit_bonus":
                return "vassal forcelimit contribution by "+((int)(_value*100)) + "%";
            case "ship_durability":
                return "ship durability by "+((int)(_value*100)) + "%";
            case "leader_naval_shock":
                return "leader naval shock by "+value;
            case "galley_power":
                return "galley power by "+((int)(_value*100)) + "%";
            case "leader_naval_fire":
                return "leader naval fire by "+value;
            case "sunk_ship_morale_hit_recieved":
                return "naval morale by "+((int)(_value*100)) + "%"; // wtf is this
            case "prestige_from_naval":
                return "prestige from naval by "+((int)(_value*100)) + "%";
            case "naval_tradition_from_battle":
                return "naval tradition from battle by "+((int)(_value*100)) + "%";
            case "sailors_recovery_speed":
                return "sailors recovery speed by "+((int)(_value*100)) + "%";
            case "heavy_ship_power":
                return "heavy ship power by "+((int)(_value*100)) + "%";
            case "global_naval_engagement_modifier":
                return "global naval engagement modifier by "+((int)(_value*100)) + "%";
        }
        return "shit";
    }
}
