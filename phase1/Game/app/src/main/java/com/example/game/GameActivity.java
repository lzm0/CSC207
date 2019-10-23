package com.example.game;

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
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    setContentView(new GameView(this));
  }
}
