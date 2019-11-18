package com.example.game;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Coin extends GameObject {

  private Paint paint;


  Coin(float x, float y) {
    super(x, y);
    paint = new Paint();
    paint.setColor(Color.YELLOW);
    paint.setTextSize(100);
  }

  void draw(Canvas canvas) {
    canvas.drawCircle(x, y, 15, paint);
  }

  void update(Level level) {
  }
}