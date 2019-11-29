package com.example.game;

import static java.lang.Math.pow;

import android.graphics.Canvas;
import android.graphics.Color;


class Ball extends GameObject {

  private double r;
  private double vx = 0;
  private double vy = 0;

  Ball(int x, int y, int radius) {
    super(x, y);
    r = radius;
    paint.setColor(Color.WHITE);
  }

  public double getR() {
    return r;
  }

  void draw(Canvas canvas) {
    canvas.drawCircle((float) getX(), (float) getY(), (float) r, paint);
  }

  void update(Level level) {
    // Set color
    paint.setColor(level.levelManager.gameSettings.getColor());

    // Algorithm for resolving collision
    double elasticity = level.levelManager.gameSettings.getElasticity();
    vx += level.getAx();
    vy += level.getAy();
    for (int i = 0; i < level.gameObjects.size(); i++) {
      GameObject obj = level.gameObjects.get(i);

      if (obj instanceof Wall) {
        Wall wall = (Wall) obj;
        if (wall.getX1() > 0) { // If the wall is horizontal
          if (wall.getX() <= getX() && getX() <= wall.getX() + wall.getX1()) {
            if (getY() > wall.getY() && (getY() + vy) - wall.getY() < r) {
              setY(wall.getY() + r + 1);
              vy = -(elasticity * vy);
            } else if (getY() < wall.getY() && wall.getY() - (getY() + vy) < r) {
              setY(wall.getY() - r - 1);
              vy = -(elasticity * vy);
            }
          }
        } else { // If the wall is vertical
          if (wall.getY() <= getY() && getY() <= wall.getY() + wall.getY1()) {
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
        if (pow(coin.getX() - getX(), 2) + pow(coin.getY() - getY(), 2)
            < pow(15 + getR(), 2)) {
          level.gameObjects.remove(i);
          i--;
          level.addCoin();
        }
      }

      if (obj instanceof Blackhole) {
        Blackhole blackhole = (Blackhole) obj;
        if (pow(blackhole.getX() - getX(), 2) + pow(blackhole.getY() - getY(), 2)
            < pow(blackhole.getR(), 2)) {
          level.restart();
        }
      }

      if (obj instanceof Enemy) {
        Enemy enemy = (Enemy) obj;
        if (pow(enemy.getX() - getX(), 2) + pow(enemy.getY() - getY(), 2)
            < pow(enemy.getR() + getR(), 2)) {
          level.restart();
        }
      }
    }
    setX(getX() + vx);
    setY(getY() + vy);
  }
}

