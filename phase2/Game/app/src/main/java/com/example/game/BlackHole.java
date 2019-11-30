package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import static java.lang.Math.pow;

class BlackHole extends GameObject {

  private double r;

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

  void update(Level level) {
  }
}