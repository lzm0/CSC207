package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private final String File_Name = "GameData";
    private Float x;
    private Float y;
    private int level;
    private String username;


    public UserManager(String username) {
        this.username = username;
    }

    public void updateInfo(Float x, Float y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }


    public void saveUserInfo(String username, Context context) {
        SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        SharedPreferences.OnSharedPreferenceChangeListener changeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {

            @Override
            public void onSharedPreferenceChanged(SharedPreferences preferences, String key) {
            }
        };
        userInfo.registerOnSharedPreferenceChangeListener(changeListener);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putFloat(username + "x", x);
        editor.putFloat(username + "y", y);
        editor.putInt(username + "Level", level);
        editor.apply();
    }

    public void getUserInfo(Context context) {
        SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        Float userx = userInfo.getFloat(username + "x", 0);
        Float usery = userInfo.getFloat(username + "y", 0);
        int level = userInfo.getInt(username + "Level", 1);
    }

    public void removeUserInfo(Context context, String key) {
        SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.remove(key + "x");
        editor.remove(key + "y");
        editor.apply();
    }

    public void clearUserInfo(Context context) {
        SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.clear();
        editor.apply();
    }
}

