package com.example.game;

import android.graphics.Canvas;

abstract class GameObject {

  float x;
  float y;

  GameObject(float x, float y) {
    this.x = x;
    this.y = y;
  }

  abstract void draw(Canvas canvas);

  abstract void update(Level level);
}
