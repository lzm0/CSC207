package com.example.game;

import android.graphics.Canvas;
import android.graphics.Paint;

abstract class GameObject {

  private float x;
  private float y;
  Paint paint;

  GameObject(float x, float y) {
    this.x = x;
    this.y = y;
    paint = new Paint();
  }

  float getX() {
    return x;
  }

  void setX(float x) {
    this.x = x;
  }

  float getY() {
    return y;
  }

  void setY(float y) {
    this.y = y;
  }

  abstract void draw(Canvas canvas);

  abstract void update(Level level);
}
