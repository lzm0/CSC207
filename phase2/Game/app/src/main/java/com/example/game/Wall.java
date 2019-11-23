package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;

class Wall extends GameObject {

  private float x1;
  private float y1;

  Wall(int x, int y, int x1, int y1) {
    super(x, y);
    this.y1 = y1;
    this.x1 = x1;
    paint.setColor(Color.WHITE);
    paint.setStrokeWidth(10);
  }

  float getX1() {
    return x1;
  }


  float getY1() {
    return y1;
  }

  void draw(Canvas canvas) {
    canvas.drawLine(getX(), getY(), getX() + getX1(), getY() + getY1(), paint);
  }

  void update(Level level) {
  }
}
