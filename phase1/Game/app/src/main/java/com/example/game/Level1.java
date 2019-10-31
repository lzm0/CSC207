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

class Level1 extends Level {

  Level1(int width, int height, Context context) {
    super(width, height, context);
  }

  void createGameObjects() {
    // Goal
    gameObjects.add(new Goal(100, 1750, 40));

    // Left boundary
    gameObjects.add(new Wall(0, 0, 0, getHeight()));
    // Right boundary
    gameObjects.add(new Wall(getWidth(), 0, 0, getHeight()));
    // Top boundary
    gameObjects.add(new Wall(0, 0, getWidth(), 0));
    // Bottom boundary
    gameObjects.add(new Wall(0, getHeight(), getWidth(), 0));

    // Walls
    gameObjects.add(new Wall(0, 500, 750, 0));
    gameObjects.add(new Wall(0, 1500, 750, 0));
    gameObjects.add(new Wall(330, 1000, 750, 0));

    // Blackhole
    gameObjects.add(new Blackhole(830, 500, 40));
    gameObjects.add(new Blackhole(250, 1000, 40));
    gameObjects.add(new Blackhole(830, 1500, 40));
    gameObjects.add(new Blackhole(1000, 1900, 40));
    gameObjects.add(new Blackhole(1300, 200, 40));
    gameObjects.add(new Blackhole(100, 80, 40));
    gameObjects.add(new Blackhole(80, 600, 40));
    gameObjects.add(new Blackhole(80, 1400, 40));
    gameObjects.add(new Blackhole(100, 1950, 40));

    // Ball (should be added last to prevent overlap)
    gameObjects.add(new Ball(500, 300, 30));
  }
}
