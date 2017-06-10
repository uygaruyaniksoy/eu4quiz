package com.uyaniksoy.eu4quiz.DataTypes;

import android.app.Activity;

import com.uyaniksoy.eu4quiz.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Capital extends BaseDataType {
    private Activity activity;
    private String name;

    public Capital(String name, Activity activity) {
        this.name = name; this.activity = activity;
    }

    @Override
    public String toString() {
        InputStream is = activity.getResources().openRawResource(R.raw.provinces);
        JSONObject o;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            o = new JSONObject(json);
            return o.getString(name);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return "";
    }
}
