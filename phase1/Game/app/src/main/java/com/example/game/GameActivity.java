package com.example.game;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Request fullscreen and hide title bar
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getSupportActionBar().hide();

    // Force landscape only
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    Intent intent = getIntent();
    String username = intent.getStringExtra("Username");
    float elasticity = intent.getFloatExtra("Elasticity", 0.5f);
    float sensitivity = intent.getFloatExtra("Sensitivity", 0.5f);
    String color = intent.getStringExtra("Color");

    GameSettings gameSettings = new GameSettings();
    gameSettings.setElasticity(elasticity);
    gameSettings.setSensitivity(sensitivity);
    gameSettings.setColor(color);

    UserManager user = new UserManager(username);
    setContentView(new GameView(this, gameSettings, user));
  }
}
