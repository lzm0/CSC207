package com.example.game;

import static java.lang.Math.pow;

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
    paint.setColor(Color.GREEN);
    paint.setStrokeWidth(5);
    paint.setStyle(Paint.Style.STROKE);
  }

  void draw(Canvas canvas) {
    canvas.drawCircle(x, y, r, paint);
  }

  void update(Level level) {
    for (int i = 0; i < level.gameObjects.size(); i++) {
      if (level.gameObjects.get(i) instanceof Ball) {
        Ball ball = (Ball) level.gameObjects.get(i);
        // If center of the ball is inside the goal
        if (pow(x - ball.x, 2) + pow(y - ball.y, 2) < pow(r, 2)) {
          level.gameObjects.remove(i);
          i--;
          level.pass();
        }
      }
    }
  }
}