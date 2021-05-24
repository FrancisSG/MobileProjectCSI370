package com.csi370.mobileprojectcsi370;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrefConfig {

    private static final String LIST_KEY = "list_key";

    public static void writeArrayListInPref(Context context, ArrayList<AppUser> AppUserList) {
        //Gson library to allow us to store ArrayList in sharedPreference
        Gson gson = new Gson();
        String jsonString = gson.toJson(AppUserList);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static ArrayList<AppUser> readListFromSharedPreference(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<AppUser>>() {}.getType();
        ArrayList<AppUser> list = gson.fromJson(jsonString, type);

        return list;

    }

}
