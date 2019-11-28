package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;

class Coin extends GameObject {

  Coin(double x, double y) {
    super(x, y);
    paint.setColor(Color.YELLOW);
  }

  void draw(Canvas canvas) {
    canvas.drawCircle((float) getX(), (float) getY(), 15, paint);
  }

  void update(Level level) {
  }
}