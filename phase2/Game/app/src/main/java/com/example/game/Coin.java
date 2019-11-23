package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;

class Coin extends GameObject {

  Coin(float x, float y) {
    super(x, y);
    paint.setColor(Color.YELLOW);
  }

  void draw(Canvas canvas) {
    canvas.drawCircle(getX(), getY(), 15, paint);
  }

  void update(Level level) {
  }
}