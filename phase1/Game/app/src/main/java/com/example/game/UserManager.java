package com.example.game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

public class UserManager {
    private final String File_Name = "GameData";
    private int level;
    private String username;


    public UserManager(String username) {
        this.username = username;
    }


    public void setUserInfo(Context context, int number) {
        this.level = number;
        SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        SharedPreferences.OnSharedPreferenceChangeListener changeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {

            @Override
            public void onSharedPreferenceChanged(SharedPreferences preferences, String key) {
            }
        };
        userInfo.registerOnSharedPreferenceChangeListener(changeListener);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putInt(username + "Level", level);
        editor.apply();
    }

    public int getUserInfo(Context context) {
        SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        return userInfo.getInt(username + "Level", 1);
    }

    public void removeUserInfo(Context context, String key) {
        SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.remove(key + "Level");
        editor.apply();
    }

    public void clearUserInfo(Context context) {
        SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.clear();
        editor.apply();
    }
}

