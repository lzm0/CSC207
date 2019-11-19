package com.example.game;

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
    canvas.drawCircle(getX(), getY(), r, paint);
  }

  void update(Level level) {
    // Set color
    paint.setColor(level.levelManager.gameSettings.getColor());

    // Algorithm for resolving collision
    float elasticity = level.levelManager.gameSettings.getElasticity();
    vx += level.getAx();
    vy += level.getAy();
    for (int i = 0; i < level.gameObjects.size(); i++) {
      GameObject obj = level.gameObjects.get(i);

      if (obj instanceof Wall) {
        Wall wall = (Wall) obj;
        if (wall.x_1 > 0) { // If the wall is horizontal
          if (wall.getX() <= getX() && getX() <= wall.getX() + wall.x_1) {
            if (getY() > wall.getY() && (getY() + vy) - wall.getY() < r) {
              setY(wall.getY() + r + 1);
              vy = -(elasticity * vy);
            } else if (getY() < wall.getY() && wall.getY() - (getY() + vy) < r) {
              setY(wall.getY() - r - 1);
              vy = -(elasticity * vy);
            }
          }
        } else { // If the wall is vertical
          if (wall.getY() <= getY() && getY() <= wall.getY() + wall.y_1) {
            if (getX() > wall.getX() && (getX() + vx) - wall.getX() < r) {
              setX(wall.getX() + r + 1);
              vx = -(elasticity * vx);
            } else if (getX() < wall.getX() && wall.getX() - (getX() + vx) < r) {
              setX(wall.getX() - r - 1);
              vx = -(elasticity * vx);
            }
          }
        }
      }

      // If the ball meet a coin, coin disappear
      if (obj instanceof Coin) {
        Coin coin = (Coin) obj;
        if (coin.getX() >= (getX() - r) && coin.getX() <= (getX() + r) &&
            coin.getY() >= (getY() - r) && coin.getY() <= (getY() + r)) {
          level.gameObjects.remove(i);
          i--;
          level.addCoin();
        }
      }
    }
    setX(getX() + vx);
    setY(getY() + vy);
  }
}

