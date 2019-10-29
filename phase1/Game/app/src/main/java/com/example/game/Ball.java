package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Ball extends GameObject {

  private int r;
  private Paint paint;

  Ball(int x, int y, int radius) {
    super(x, y);
    this.r = radius;
    paint = new Paint();
    paint.setColor(Color.WHITE);
  }

  void draw(Canvas canvas) {
    canvas.drawCircle(x, y, r, paint);
  }

  void update(GameManager gameManager) {
    r += 1;
  }
}
