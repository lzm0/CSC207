package com.example.game;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Coin extends GameObject {

  private Paint paint;
  String text = "*";


  Coin(float x, float y) {
    super(x, y);
    paint = new Paint();
    paint.setColor(Color.YELLOW);
    paint.setTextSize(100f);
  }

  void draw(Canvas canvas) {
    canvas.drawText(text, x, y, paint);
  }

  void update(Level level) {
  }
}