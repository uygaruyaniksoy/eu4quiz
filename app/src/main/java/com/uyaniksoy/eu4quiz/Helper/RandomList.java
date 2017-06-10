package com.uyaniksoy.eu4quiz.Helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList {
    public static Integer[] randomList(int max) {
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        int r;

        while (list.size() < 4) {
            r = rand.nextInt(max);
            if (!list.contains(r))
                list.add(r);
        }
        return list.toArray(new Integer[4]);
    }

    public static Integer[] randomReligionList(JSONObject o) {
        JSONArray a = o.names();
        int size = a.length();
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> listReligion = new ArrayList<>();
        int r;

        while (list.size() < 4) {
            r = rand.nextInt(size);
            try {
                if (!list.contains(r) && !listReligion.contains(o.getJSONObject(a.getString(r)).getString("religion"))){
                    list.add(r);
                    listReligion.add(o.getJSONObject(a.getString(r)).getString("religion"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list.toArray(new Integer[4]);
    }

    public static Integer[] randomGovernmentList(JSONObject o) {
        JSONArray a = o.names();
        int size = a.length();
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> listGovernment = new ArrayList<>();
        int r;

        while (list.size() < 4) {
            r = rand.nextInt(size);
            try {
                if (!list.contains(r) && !listGovernment.contains(o.getJSONObject(a.getString(r)).getString("government"))){
                    list.add(r);
                    listGovernment.add(o.getJSONObject(a.getString(r)).getString("government"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list.toArray(new Integer[4]);
    }

    public static Integer[] randomCultureList(JSONObject o) {
        JSONArray a = o.names();
        int size = a.length();
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> listPrimaryCulture = new ArrayList<>();
        int r;

        while (list.size() < 4) {
            r = rand.nextInt(size);
            try {
                if (!list.contains(r) && !listPrimaryCulture.contains(o.getJSONObject(a.getString(r)).getString("primary_culture"))){
                    list.add(r);
                    listPrimaryCulture.add(o.getJSONObject(a.getString(r)).getString("primary_culture"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list.toArray(new Integer[4]);
    }

    public static Integer[] randomCapitalList(JSONObject o) {
        JSONArray a = o.names();
        int size = a.length();
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> listCapital = new ArrayList<>();
        int r;

        while (list.size() < 4) {
            r = rand.nextInt(size);
            try {
                if (!list.contains(r) && !listCapital.contains(o.getJSONObject(a.getString(r)).getString("capital"))){
                    list.add(r);
                    listCapital.add(o.getJSONObject(a.getString(r)).getString("capital"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list.toArray(new Integer[4]);
    }

    public static Integer[] randomIdeaList(JSONObject o, Integer[] list) {
        Integer[] res = new Integer[4];
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            try {
                res[i] = rand.nextInt(o.getJSONObject(o.names().getString(list[i])).names().length());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return res;
    }
}
