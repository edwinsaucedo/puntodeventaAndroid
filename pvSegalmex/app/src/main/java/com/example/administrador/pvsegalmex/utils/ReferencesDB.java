package com.example.administrador.pvsegalmex.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

public class ReferencesDB {
    private static SharedPreferences preferences;

    public ReferencesDB(Context appContext) {
        try {
            preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key) {
        return preferences.getString(key, "");
    }

    public void putString(String key, String value) {
        checkForNullKey(key); checkForNullValue(value);
        preferences.edit().putString(key, value).apply();
    }

    public void checkForNullKey(String key){
        if (key == null){
            throw new NullPointerException();
        }
    }

    public void checkForNullValue(String value){
        if (value == null){
            throw new NullPointerException();
        }
    }

    public void putObject(String key, Object obj){
        checkForNullKey(key);
        Gson gson = new Gson();
        putString(key, gson.toJson(obj));
    }

    public static Object getObject(String key, Class<?> classOfT){
        String json = getString(key);
        Object value = new Gson().fromJson(json, classOfT);
        if (value == null)
            throw new NullPointerException();
        return value;
    }
}
