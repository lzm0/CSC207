package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;

class GameManager {

  List<GameObject> gameObjects;

  /**
   * The number of pixels of the screen width
   */
  private int width;
  /**
   * The number of pixels of the screen height
   */
  private int height;

  private Context context;
  private SensorManager sensorManager;
  private Sensor sensor;

  private float ax;
  private float ay;

  GameManager(int width, int height, Context context) {
    this.width = width;
    this.height = height;
    this.context = context;
    this.gameObjects = new ArrayList<>();
    sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    sensorManager.registerListener(
        new SensorEventListener() {
          public void onSensorChanged(SensorEvent event) {
            ax = event.values[1];
            ay = event.values[0];
          }

          public void onAccuracyChanged(Sensor sensor, int accuracy) {
          }
        },
        sensor,
        SensorManager.SENSOR_DELAY_GAME);
  }

  float getAx() {
    return ax;
  }

  float getAy() {
    return ay;
  }

  int getHeight() {
    return height;
  }

  int getWidth() {
    return  width;
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

  void createGameObjects() {
    gameObjects.add(new Ball(1000, 500, 30));
  }
}
