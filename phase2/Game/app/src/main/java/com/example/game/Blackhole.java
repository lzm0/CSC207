package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import static java.lang.Math.pow;

class Blackhole extends GameObject {

  private float r;

  Blackhole(int x, int y, int radius) {
    super(x, y);
    r = radius;
    paint.setColor(Color.RED);
    paint.setStrokeWidth(5);
    paint.setStyle(Paint.Style.STROKE);
  }

  void draw(Canvas canvas) {
    canvas.drawCircle(getX(), getY(), r, paint);
  }

  void update(Level level) {
    for (int i = 0; i < level.gameObjects.size(); i++) {
      if (level.gameObjects.get(i) instanceof Ball) {
        Ball ball = (Ball) level.gameObjects.get(i);
        // If center of the ball is inside the blackhole.
        if (pow(getX() - ball.getX(), 2) + pow(getY() - ball.getY(), 2) < pow(r, 2)) {
          level.restart();
        }
      }
    }
  }
}