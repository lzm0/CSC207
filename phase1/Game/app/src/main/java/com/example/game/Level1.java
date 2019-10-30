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
        gameObjects.add(new Goal(200, 300, 40));

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

        // Ball
        gameObjects.add(new Ball(500, 300, 30));
    }
}
