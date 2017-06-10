package com.uyaniksoy.eu4quiz.Helper;

import android.app.Activity;
import android.util.Log;

import com.uyaniksoy.eu4quiz.DataTypes.Ability;
import com.uyaniksoy.eu4quiz.DataTypes.Advisor;
import com.uyaniksoy.eu4quiz.DataTypes.Age;
import com.uyaniksoy.eu4quiz.DataTypes.Building;
import com.uyaniksoy.eu4quiz.DataTypes.Capital;
import com.uyaniksoy.eu4quiz.DataTypes.Country;
import com.uyaniksoy.eu4quiz.DataTypes.Government;
import com.uyaniksoy.eu4quiz.DataTypes.Idea;
import com.uyaniksoy.eu4quiz.DataTypes.Modifier;
import com.uyaniksoy.eu4quiz.DataTypes.Objective;
import com.uyaniksoy.eu4quiz.DataTypes.PrimaryCulture;
import com.uyaniksoy.eu4quiz.DataTypes.Religion;
import com.uyaniksoy.eu4quiz.DataTypes.TradeGood;
import com.uyaniksoy.eu4quiz.Question.AbilityAgeQuestion;
import com.uyaniksoy.eu4quiz.Question.AdvisorModifierQuestion;
import com.uyaniksoy.eu4quiz.Question.AgeAbilityQuestion;
import com.uyaniksoy.eu4quiz.Question.AgeObjectiveQuestion;
import com.uyaniksoy.eu4quiz.Question.BuildingModifierQuestion;
import com.uyaniksoy.eu4quiz.Question.CountryCapitalQuestion;
import com.uyaniksoy.eu4quiz.Question.CountryGovernmentQuestion;
import com.uyaniksoy.eu4quiz.Question.CountryPrimaryCultureQuestion;
import com.uyaniksoy.eu4quiz.Question.CountryReligionQuestion;
import com.uyaniksoy.eu4quiz.Question.FlagCountryQuestion;
import com.uyaniksoy.eu4quiz.Question.IdeaModifierQuestion;
import com.uyaniksoy.eu4quiz.Question.ManufactoryTradeGoodQuestion;
import com.uyaniksoy.eu4quiz.Question.ModifierAdvisorQuestion;
import com.uyaniksoy.eu4quiz.Question.ObjectiveAgeQuestion;
import com.uyaniksoy.eu4quiz.Question.Question;
import com.uyaniksoy.eu4quiz.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class QuestionGenerator {
    private final int qMode;
    private Activity activity;

    public QuestionGenerator(Activity activity, int qMode) {
        this.activity = activity;
        this.qMode = qMode;
    }

    public Question next() {
        Random rand = new Random();
        int r = rand.nextInt(140);

        if (r < 10 && (qMode & 1) != 0)
            return getAgeAbilityQuestion();
        else if (r < 20 && (qMode & 1) != 0)
            return getAbilityAgeQuestion();
        else if (r < 30 && (qMode & 1) != 0)
            return getObjectiveAgeQuestion();
        else if (r < 40 && (qMode & 1) != 0)
            return getAgeObjectiveQuestion();
        else if (r < 50 && (qMode & 16) != 0)
            return getAdvisorModifierQuestion();
        else if (r < 60 && (qMode & 16) != 0)
            return getModifierAdvisorQuestion();
        else if (r < 70 && (qMode & 2) != 0)
            return getBuildingModifierQuestion();
        else if (r < 80 && (qMode & 2) != 0)
            return getManufactoryTradeGoodQuestion();
        else if (r < 90 && (qMode & 4) != 0)
            return getCountryGovernmentQuestion();
        else if (r < 100 && (qMode & 4) != 0)
            return getCountryReligionQuestion();
        else if (r < 110 && (qMode & 4) != 0)
            return getCountryPrimaryCultureQuestion();
        else if (r < 120 && (qMode & 4) != 0)
            return getCountryCapitalQuestion();
        else if (r < 130 && (qMode & 8) != 0)
            return getFlagCountryQuestion();
        else if (r < 140 && (qMode & 32) != 0)
            return getIdeaModifierQuestion();
        Log.d("HELP", "this shouldn't happen");
        return next();
    }


    private AdvisorModifierQuestion getAdvisorModifierQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.advisortypes);
        JSONObject o = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();

            Integer[] list = RandomList.randomList(size);
            return new AdvisorModifierQuestion().ask(a.getString(list[0]))
                    .right(o.getJSONObject(a.getString(list[0])).names().getString(0),o.getJSONObject(a.getString(list[0])).getString(o.getJSONObject(a.getString(list[0])).names().getString(0)))
                    .wrong(o.getJSONObject(a.getString(list[1])).names().getString(0),o.getJSONObject(a.getString(list[1])).getString(o.getJSONObject(a.getString(list[1])).names().getString(0)))
                    .wrong(o.getJSONObject(a.getString(list[2])).names().getString(0),o.getJSONObject(a.getString(list[2])).getString(o.getJSONObject(a.getString(list[2])).names().getString(0)))
                    .wrong(o.getJSONObject(a.getString(list[3])).names().getString(0),o.getJSONObject(a.getString(list[3])).getString(o.getJSONObject(a.getString(list[3])).names().getString(0)));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new AdvisorModifierQuestion();
    }

    private ModifierAdvisorQuestion getModifierAdvisorQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.advisortypes);
        JSONObject o = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();

            Integer[] list = RandomList.randomList(size);
            return new ModifierAdvisorQuestion().ask(o.getJSONObject(a.getString(list[0])).names().getString(0),o.getJSONObject(a.getString(list[0])).getString(o.getJSONObject(a.getString(list[0])).names().getString(0)))
                    .right(new Advisor(a.getString(list[0])))
                    .wrong(new Advisor(a.getString(list[1])))
                    .wrong(new Advisor(a.getString(list[2])))
                    .wrong(new Advisor(a.getString(list[3])));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new ModifierAdvisorQuestion();
    }

    private AgeObjectiveQuestion getAgeObjectiveQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.ages);
        JSONObject o = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomList(size);
            return new AgeObjectiveQuestion().ask(o.names().getString(list[0]))
                    .right(new Objective(o.getJSONObject(a.getString(list[0])).getJSONArray("objectives").getString(rand.nextInt(o.getJSONObject(a.getString(list[0])).getJSONArray("objectives").length()-1))))
                    .wrong(new Objective(o.getJSONObject(a.getString(list[1])).getJSONArray("objectives").getString(rand.nextInt(o.getJSONObject(a.getString(list[1])).getJSONArray("objectives").length()-1))))
                    .wrong(new Objective(o.getJSONObject(a.getString(list[2])).getJSONArray("objectives").getString(rand.nextInt(o.getJSONObject(a.getString(list[2])).getJSONArray("objectives").length()-1))))
                    .wrong(new Objective(o.getJSONObject(a.getString(list[3])).getJSONArray("objectives").getString(rand.nextInt(o.getJSONObject(a.getString(list[3])).getJSONArray("objectives").length()-1))));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new AgeObjectiveQuestion();
    }

    private ObjectiveAgeQuestion getObjectiveAgeQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.ages);
        JSONObject o = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomList(size);
            return new ObjectiveAgeQuestion().ask(new Objective(o.getJSONObject(a.getString(list[0])).getJSONArray("objectives").getString(rand.nextInt(o.getJSONObject(a.getString(list[0])).getJSONArray("objectives").length()-1))))
                    .right(new Age(o.names().getString(list[0])))
                    .wrong(new Age(o.names().getString(list[1])))
                    .wrong(new Age(o.names().getString(list[2])))
                    .wrong(new Age(o.names().getString(list[3])));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new ObjectiveAgeQuestion();
    }

    private AgeAbilityQuestion getAgeAbilityQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.ages);
        JSONObject o = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomList(size);
            return new AgeAbilityQuestion().ask(o.names().getString(list[0]))
                    .right(new Ability(o.getJSONObject(a.getString(list[0])).getJSONArray("abilities").getString(rand.nextInt(o.getJSONObject(a.getString(list[0])).getJSONArray("abilities").length()-1))))
                    .wrong(new Ability(o.getJSONObject(a.getString(list[1])).getJSONArray("abilities").getString(rand.nextInt(o.getJSONObject(a.getString(list[1])).getJSONArray("abilities").length()-1))))
                    .wrong(new Ability(o.getJSONObject(a.getString(list[2])).getJSONArray("abilities").getString(rand.nextInt(o.getJSONObject(a.getString(list[2])).getJSONArray("abilities").length()-1))))
                    .wrong(new Ability(o.getJSONObject(a.getString(list[3])).getJSONArray("abilities").getString(rand.nextInt(o.getJSONObject(a.getString(list[3])).getJSONArray("abilities").length()-1))));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new AgeAbilityQuestion();
    }

    private AbilityAgeQuestion getAbilityAgeQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.ages);
        JSONObject o = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomList(size);
            return new AbilityAgeQuestion().ask(new Ability(o.getJSONObject(a.getString(list[0])).getJSONArray("abilities").getString(rand.nextInt(o.getJSONObject(a.getString(list[0])).getJSONArray("abilities").length()-1))))
                    .right(new Age(o.names().getString(list[0])))
                    .wrong(new Age(o.names().getString(list[1])))
                    .wrong(new Age(o.names().getString(list[2])))
                    .wrong(new Age(o.names().getString(list[3])));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new AbilityAgeQuestion();
    }

    private BuildingModifierQuestion getBuildingModifierQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.buildings);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomList(size);
            return new BuildingModifierQuestion().ask(new Building(o.names().getString(list[0])))
                    .right(new Modifier(o.getJSONObject(o.names().getString(list[0])).names().getString(0),o.getJSONObject(o.names().getString(list[0])).getString(o.getJSONObject(o.names().getString(list[0])).names().getString(0))))
                    .wrong(new Modifier(o.getJSONObject(o.names().getString(list[1])).names().getString(0),o.getJSONObject(o.names().getString(list[1])).getString(o.getJSONObject(o.names().getString(list[1])).names().getString(0))))
                    .wrong(new Modifier(o.getJSONObject(o.names().getString(list[2])).names().getString(0),o.getJSONObject(o.names().getString(list[2])).getString(o.getJSONObject(o.names().getString(list[2])).names().getString(0))))
                    .wrong(new Modifier(o.getJSONObject(o.names().getString(list[3])).names().getString(0),o.getJSONObject(o.names().getString(list[3])).getString(o.getJSONObject(o.names().getString(list[3])).names().getString(0))));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new BuildingModifierQuestion();
    }

    private ManufactoryTradeGoodQuestion getManufactoryTradeGoodQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.manufactories);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomList(size);
            return new ManufactoryTradeGoodQuestion().ask(new Building(o.names().getString(list[0])))
                    .right(new TradeGood(o.getJSONArray(o.names().getString(list[0])).getString(rand.nextInt(o.getJSONArray(o.names().getString(list[0])).length()))))
                    .wrong(new TradeGood(o.getJSONArray(o.names().getString(list[1])).getString(rand.nextInt(o.getJSONArray(o.names().getString(list[1])).length()))))
                    .wrong(new TradeGood(o.getJSONArray(o.names().getString(list[2])).getString(rand.nextInt(o.getJSONArray(o.names().getString(list[2])).length()))))
                    .wrong(new TradeGood(o.getJSONArray(o.names().getString(list[3])).getString(rand.nextInt(o.getJSONArray(o.names().getString(list[3])).length()))));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new ManufactoryTradeGoodQuestion();
    }

    private CountryGovernmentQuestion getCountryGovernmentQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.countries);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomGovernmentList(o);
            return new CountryGovernmentQuestion().ask(new Country(o.names().getString(list[0])))
                    .right(new Government(o.getJSONObject(o.names().getString(list[0])).getString("government")))
                    .wrong(new Government(o.getJSONObject(o.names().getString(list[1])).getString("government")))
                    .wrong(new Government(o.getJSONObject(o.names().getString(list[2])).getString("government")))
                    .wrong(new Government(o.getJSONObject(o.names().getString(list[3])).getString("government")));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new CountryGovernmentQuestion();
    }

    private CountryReligionQuestion getCountryReligionQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.countries);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomReligionList(o);
            return new CountryReligionQuestion().ask(new Country(o.names().getString(list[0])))
                    .right(new Religion(o.getJSONObject(o.names().getString(list[0])).getString("religion")))
                    .wrong(new Religion(o.getJSONObject(o.names().getString(list[1])).getString("religion")))
                    .wrong(new Religion(o.getJSONObject(o.names().getString(list[2])).getString("religion")))
                    .wrong(new Religion(o.getJSONObject(o.names().getString(list[3])).getString("religion")));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new CountryReligionQuestion();
    }

    private CountryPrimaryCultureQuestion getCountryPrimaryCultureQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.countries);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomCultureList(o);
            return new CountryPrimaryCultureQuestion().ask(new Country(o.names().getString(list[0])))
                    .right(new PrimaryCulture(o.getJSONObject(o.names().getString(list[0])).getString("primary_culture")))
                    .wrong(new PrimaryCulture(o.getJSONObject(o.names().getString(list[1])).getString("primary_culture")))
                    .wrong(new PrimaryCulture(o.getJSONObject(o.names().getString(list[2])).getString("primary_culture")))
                    .wrong(new PrimaryCulture(o.getJSONObject(o.names().getString(list[3])).getString("primary_culture")));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new CountryPrimaryCultureQuestion();
    }

    private CountryCapitalQuestion getCountryCapitalQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.countries);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomCapitalList(o);
            return new CountryCapitalQuestion().ask(new Country(o.names().getString(list[0])))
                    .right(new Capital(o.getJSONObject(o.names().getString(list[0])).getString("capital"),activity))
                    .wrong(new Capital(o.getJSONObject(o.names().getString(list[1])).getString("capital"),activity))
                    .wrong(new Capital(o.getJSONObject(o.names().getString(list[2])).getString("capital"),activity))
                    .wrong(new Capital(o.getJSONObject(o.names().getString(list[3])).getString("capital"),activity));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new CountryCapitalQuestion();
    }

    private IdeaModifierQuestion getIdeaModifierQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.ideas);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomList(size);
            Integer[] listIdea = RandomList.randomIdeaList(o,list);
            return new IdeaModifierQuestion().ask(new Idea(o.names().getString(list[0])))
                    .right(new Modifier(o.getJSONObject(o.names().getString(list[0])).names().getString(listIdea[0]),o.getJSONObject(o.names().getString(list[0])).getString(o.getJSONObject(o.names().getString(list[0])).names().getString(listIdea[0]))))
                    .wrong(new Modifier(o.getJSONObject(o.names().getString(list[1])).names().getString(listIdea[1]),o.getJSONObject(o.names().getString(list[1])).getString(o.getJSONObject(o.names().getString(list[1])).names().getString(listIdea[1]))))
                    .wrong(new Modifier(o.getJSONObject(o.names().getString(list[2])).names().getString(listIdea[2]),o.getJSONObject(o.names().getString(list[2])).getString(o.getJSONObject(o.names().getString(list[2])).names().getString(listIdea[2]))))
                    .wrong(new Modifier(o.getJSONObject(o.names().getString(list[3])).names().getString(listIdea[3]),o.getJSONObject(o.names().getString(list[3])).getString(o.getJSONObject(o.names().getString(list[3])).names().getString(listIdea[3]))));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new IdeaModifierQuestion();
    }

    private FlagCountryQuestion getFlagCountryQuestion() {
        InputStream is = activity.getResources().openRawResource(R.raw.countrytags);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);

            JSONArray a = o.names();
            size = a.length();
            Random rand = new Random();

            Integer[] list = RandomList.randomList(size);
            return new FlagCountryQuestion().ask(activity.getResources().getIdentifier(a.getString(list[0]).toLowerCase(),"drawable",activity.getPackageName()))
                    .right(new Country(o.getString(a.getString(list[0]))))
                    .wrong(new Country(o.getString(a.getString(list[1]))))
                    .wrong(new Country(o.getString(a.getString(list[2]))))
                    .wrong(new Country(o.getString(a.getString(list[3]))));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new FlagCountryQuestion();
    }
}
