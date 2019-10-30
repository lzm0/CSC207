package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Goal extends GameObject {

  private float r;
  private Paint paint;

  Goal(int x, int y, int radius) {
    super(x, y);
    r = radius;
    paint = new Paint();
    paint.setColor(Color.RED);
    paint.setStrokeWidth(r - 45);
    paint.setStyle(Paint.Style.STROKE);
  }

  void draw(Canvas canvas) {
    canvas.drawCircle(x, y, r, paint);
  }

  void update(GameManager gameManager) {
    if (gameManager.isPass()) {
      paint.setColor(Color.GREEN);
    }
  }
}