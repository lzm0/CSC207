package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class BlackHole extends GameObject {

  private double r;

  /**
   * Class constructor that extends GameObject.
   *
   * @param x the x-coordinate of this BlackHole
   * @param y the y-coordinate of this BlackHole
   * @param radius the radius of this BlackHole
   */
  BlackHole(int x, int y, int radius) {
    super(x, y);
    r = radius;
    paint.setColor(Color.RED);
    paint.setStrokeWidth(5);
    paint.setStyle(Paint.Style.STROKE);
  }

  public double getR() {
    return r;
  }

  void draw(Canvas canvas) {
    canvas.drawCircle((float) getX(), (float) getY(), (float) r, paint);
  }

  void update(Level level) {}
}
