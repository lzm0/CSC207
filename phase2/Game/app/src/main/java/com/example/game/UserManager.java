package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;

class UserManager {

  private final String File_Name = "GameData";
  private String username;


  UserManager(String username) {
    this.username = username;
  }

  String getUsername() {
    return this.username;
  }


  void setUserInfo(Context context, int number) {
    SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
    SharedPreferences.OnSharedPreferenceChangeListener changeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {

          @Override
          public void onSharedPreferenceChanged(SharedPreferences preferences, String key) {
          }
    };
    userInfo.registerOnSharedPreferenceChangeListener(changeListener);
    SharedPreferences.Editor editor = userInfo.edit();
    editor.putInt(username + "Level", number);
    editor.apply();
  }

  int getUserInfo(Context context) {
    SharedPreferences userInfo = context.getSharedPreferences(File_Name, Context.MODE_PRIVATE);
    return userInfo.getInt(username + "Level", 1);
  }
}

