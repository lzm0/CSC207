package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Wall extends GameObject {

  private Paint paint;
  float y_1;
  float x_1;

  Wall(int x, int y, int x1, int y1) {
    super(x, y);
    y_1 = y1;
    x_1 = x1;
    paint = new Paint();
    paint.setColor(Color.WHITE);
    paint.setStrokeWidth(10);
  }

  void draw(Canvas canvas) {
    canvas.drawLine(x, y, x + x_1, y + y_1, paint);
  }

  void update(GameManager gameManager) {
  }
}
