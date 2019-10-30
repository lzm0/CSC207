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

  private float ax;
  private float ay;
  private boolean pass;

  GameManager(int width, int height, Context context) {
    this.width = width;
    this.height = height;
    this.gameObjects = new ArrayList<>();
    this.pass = false;
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

  float getAx() {
    return ax;
  }

  boolean isPass() {
    return pass;
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
    for (GameObject ojb : gameObjects) {
      for (GameObject g : gameObjects){
      if (ojb instanceof Ball && g instanceof Goal
              && ojb.x <= g.x + 8 && g.x - 8 <= ojb.x && ojb.y <= g.y + 8 && g.y - 8 <= ojb.y){
        pass = true;
      }
    }
    }


  }

  void draw(Canvas canvas) {
    for (GameObject obj : gameObjects) {
      obj.draw(canvas);
    }
  }

  void createGameObjects() {
    // Left boundary
    gameObjects.add(new Wall(0, 0, 0, getHeight()));
    // Right boundary
    gameObjects.add(new Wall(getWidth(), 0, 0, getHeight()));
    // Top boundary
    gameObjects.add(new Wall(0, 0, getWidth(), 0));
    // Bottom boundary
    gameObjects.add(new Wall(0, getHeight(), getWidth(), 0));

    gameObjects.add(new Ball(500, 300, 30));
    gameObjects.add(new Wall(0, 500, 750, 0));
    gameObjects.add(new Wall(0, 1500, 750, 0));
    gameObjects.add(new Wall(330, 1000, 750, 0));
    gameObjects.add(new Goal(100, 300, 55));
  }
}
