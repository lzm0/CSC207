package com.example.game;

import static java.lang.Math.abs;

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

    void update(Level level) {
        vx += level.getAx();
        vy += level.getAy();
        for (GameObject obj : level.gameObjects) {
      if (obj instanceof Wall) {
        Wall wall = (Wall) obj;
        if (wall.x_1 > 0) { // If the wall is horizontal
          if (wall.x <= x && x <= wall.x + wall.x_1 && abs(y + vy - wall.y) <= r) {
            vy = -0.3f * vy;
            if (y > wall.y) {
              y = wall.y + r + 1;
            } else {
              y = wall.y - r - 1;
            }
          }
        } else { // If the wall is vertical
          if (wall.y <= y && y <= wall.y + wall.y_1 && abs(x + vx - wall.x) <= r) {
            vx = -0.3f * vx;
            if (x > wall.x) {
              x = wall.x + r + 1;
            } else {
              x = wall.x - r - 1;
            }
          }
        }
      }
    }
    x += vx;
    y += vy;
  }
}
