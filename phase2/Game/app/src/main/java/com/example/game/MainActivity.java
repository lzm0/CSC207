package com.example.game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build.VERSION_CODES;
import android.text.InputType;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

  private String username = "Username";

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

    // Display main activity
    setContentView(R.layout.activity_main);

    // Disable the play button
    findViewById(R.id.play_button).setEnabled(false);
  }

  public void startGame(View view) {
    SeekBar elasticitySeekBar = findViewById(R.id.elasticity_seekbar);
    SeekBar sensitivitySeekBar = findViewById(R.id.sensitivity_seekbar);
    Spinner colorSpinner = findViewById(R.id.color_spinner);
    double elasticity = (double) elasticitySeekBar.getProgress() / elasticitySeekBar.getMax();
    double sensitivity = (double) sensitivitySeekBar.getProgress() / sensitivitySeekBar.getMax();
    String color = colorSpinner.getSelectedItem().toString();

    Intent intent = new Intent(this, GameActivity.class);
    intent.putExtra("Username", username);
    intent.putExtra("Elasticity", elasticity);
    intent.putExtra("Sensitivity", sensitivity);
    intent.putExtra("Color", color);
    startActivity(intent);
  }

  public void login(View view) {
    // Display a dialogue
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Enter your username:");
    final EditText input = new EditText(this);
    input.setInputType(InputType.TYPE_CLASS_TEXT);
    input.setText("Username");
    builder.setView(input);
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        // Set username and enable play button
        username = input.getText().toString();
        findViewById(R.id.play_button).setEnabled(true);
      }
    });
    builder.show();
  }
}
