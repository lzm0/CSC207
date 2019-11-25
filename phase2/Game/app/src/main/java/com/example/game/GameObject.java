package com.example.game;

import android.graphics.Canvas;
import android.graphics.Paint;

abstract class GameObject {

  private double x;
  private double y;
  Paint paint;

  GameObject(double x, double y) {
    this.x = x;
    this.y = y;
    paint = new Paint();
  }

  double getX() {
    return x;
  }

  void setX(double x) {
    this.x = x;
  }

  double getY() {
    return y;
  }

  void setY(double y) {
    this.y = y;
  }

  abstract void draw(Canvas canvas);

  abstract void update(Level level);
}
