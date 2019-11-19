package com.example.game;

import android.graphics.Canvas;

abstract class GameObject {

  private float x;
  private float y;

  GameObject(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }

  abstract void draw(Canvas canvas);

  abstract void update(Level level);
}
