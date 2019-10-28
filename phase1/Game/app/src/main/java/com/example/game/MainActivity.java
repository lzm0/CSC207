package com.example.game;

import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

  @RequiresApi(api = VERSION_CODES.KITKAT)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Request fullscreen and hide title bar
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    Objects.requireNonNull(getSupportActionBar()).hide();

    // Force landscape only
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    // Display main activity
    setContentView(R.layout.activity_main);
  }

  public void startGame(View view) {
    Intent intent = new Intent(this, GameActivity.class);
    startActivity(intent);
  }
}
