package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Wall extends GameObject {

  private Paint paint;
  float x1;
  float y1;

  Wall(int x, int y, int x1, int y1) {
    super(x, y);
    this.y1 = y1;
    this.x1 = x1;
    paint = new Paint();
    paint.setColor(Color.WHITE);
    paint.setStrokeWidth(10);
  }

  void draw(Canvas canvas) {
    canvas.drawLine(getX(), getY(), getX() + x1, getY() + y1, paint);
  }

  void update(Level level) {
  }
}
