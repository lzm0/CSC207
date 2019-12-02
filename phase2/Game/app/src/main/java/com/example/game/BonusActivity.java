package com.example.game;

import android.os.Build.VERSION_CODES;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Objects;

public class BonusActivity extends AppCompatActivity {
    String username;

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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Display bonus activity
        setContentView(R.layout.activity_bonus);

        Intent intent = getIntent();
        username = intent.getStringExtra("Username");
    }

    public void startGame(View view) {
        SeekBar elasticitySeekBar = findViewById(R.id.elasticity_seekbar);
        SeekBar sensitivitySeekBar = findViewById(R.id.sensitivity_seekbar);
        Spinner colorSpinner = findViewById(R.id.color_spinner);
        Spinner levelsSpinner = findViewById(R.id.level_spinner);
        double elasticity = (double) elasticitySeekBar.getProgress() / elasticitySeekBar.getMax();
        double sensitivity = (double) sensitivitySeekBar.getProgress() / sensitivitySeekBar.getMax();
        String color = colorSpinner.getSelectedItem().toString();
        String levels = levelsSpinner.getSelectedItem().toString();
        UserManager userManager = new UserManager(username);
        userManager.setUserInfo(this, Integer.valueOf(levels));

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("Username", username);
        intent.putExtra("Elasticity", elasticity);
        intent.putExtra("Sensitivity", sensitivity);
        intent.putExtra("Color", color);
        System.out.println(levels);
        startActivity(intent);
    }

}
