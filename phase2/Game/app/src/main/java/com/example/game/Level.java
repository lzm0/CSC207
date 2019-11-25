package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

abstract class Level {

  List<GameObject> gameObjects;

  /**
   * The number of pixels of the screen width
   */
  private int width;
  /**
   * The number of pixels of the screen height
   */
  private int height;

  private double ax;
  private double ay;
  LevelManager levelManager;
  private int deathCount;
  private long startTime;
  private int coinCount;

  Level(int width, int height, final LevelManager levelManager) {
    this.width = width;
    this.height = height;
    this.gameObjects = new ArrayList<>();
    this.levelManager = levelManager;
    SensorManager sensorManager =
        (SensorManager) levelManager.getContext().getSystemService(Context.SENSOR_SERVICE);
    Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    sensorManager.registerListener(
        new SensorEventListener() {
          public void onSensorChanged(SensorEvent event) {
            ax = (0.1 + 0.2 * levelManager.gameSettings.getSensitivity()) * -event.values[0];
            ay = (0.1 + 0.2 * levelManager.gameSettings.getSensitivity()) * event.values[1];
          }

          public void onAccuracyChanged(Sensor sensor, int accuracy) {
          }
        },
        sensor,
        SensorManager.SENSOR_DELAY_GAME);
  }

  void start() {
    createGameObjects();
    startTime = System.currentTimeMillis() / 1000;
  }

  void pass() {
    final long time = System.currentTimeMillis() / 1000 - startTime;

    // Show game statistics
    Handler handler = new Handler(Looper.getMainLooper());
    handler.post(
        new Runnable() {
          @Override
          public void run() {
            Toast.makeText(levelManager.getContext(),
                "Level passed!\nDeath count: " + deathCount +
                    "\nTime taken: " + time + "s" + "\nCoins Collected: "
                    + coinCount,
                Toast.LENGTH_SHORT).show();
          }
        }
    );
    levelManager.finishLevel(levelManager.getContext());
  }

  double getAx() {
    return ax;
  }

  double getAy() {
    return ay;
  }

  int getHeight() {
    return height;
  }

  int getWidth() {
    return width;
  }

  void restart() {
    this.gameObjects.clear();
    this.deathCount++;
    this.coinCount = 0;
    this.createGameObjects();
  }

  void addCoin() {
    this.coinCount++;
  }

  void update() {
    for (GameObject obj : gameObjects) {
      obj.update(this);
    }
  }

  void draw(Canvas canvas) {
    for (GameObject obj : gameObjects) {
      obj.draw(canvas);
    }
  }

  abstract void createGameObjects();
}