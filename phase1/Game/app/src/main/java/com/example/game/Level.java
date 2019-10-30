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

  private float ax;
  private float ay;
  private Context context;

  Level(int width, int height, Context context) {
    this.width = width;
    this.height = height;
    this.gameObjects = new ArrayList<>();
    this.context = context;
    SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    sensorManager.registerListener(
        new SensorEventListener() {
          public void onSensorChanged(SensorEvent event) {
            ax = 0.2f * -event.values[0];
            ay = 0.2f * event.values[1];
          }

          public void onAccuracyChanged(Sensor sensor, int accuracy) {
          }
        },
        sensor,
        SensorManager.SENSOR_DELAY_GAME);
  }

  void pass() {
    Handler handler = new Handler(Looper.getMainLooper());
    handler.post(
        new Runnable() {
          @Override
          public void run() {
            Toast.makeText(context, "Level passed!", Toast.LENGTH_SHORT).show();
          }
        }
    );
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
    return width;
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
