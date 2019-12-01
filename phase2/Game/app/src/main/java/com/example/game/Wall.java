package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;

class Wall extends GameObject {

  private double x1;
  private double y1;

  /**
   * Class constructor that extends GameObject.
   *
   * @param x   the x-coordinate of this Wall
   * @param y   the y-coordinate of this Wall
   * @param x1   the width of this Wall
   * @param y1   the length of this Wall
   */
  Wall(int x, int y, int x1, int y1) {
    super(x, y);
    this.y1 = y1;
    this.x1 = x1;
    paint.setColor(Color.WHITE);
    paint.setStrokeWidth(10);
  }

  double getX1() {
    return x1;
  }


  double getY1() {
    return y1;
  }

  void draw(Canvas canvas) {
    canvas.drawLine((float) getX(), (float) getY(),
        (float) (getX() + getX1()), (float) (getY() + getY1()), paint);
  }

  void update(Level level) {
  }
}
