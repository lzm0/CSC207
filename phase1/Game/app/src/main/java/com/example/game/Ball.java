package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


class Ball extends GameObject {

  private float r;
  private float vx = 0;
  private float vy = 0;
  private Paint paint;

  Ball(int x, int y, int radius) {
    super(x, y);
    r = radius;
    paint = new Paint();
    paint.setColor(Color.WHITE);
  }

  void draw(Canvas canvas) {
    canvas.drawCircle(x, y, r, paint);
  }

  void update(GameManager gameManager) {
    vx += gameManager.getAx();
    vy += gameManager.getAy();
    x += vx;
    y += vy;
  }
}
