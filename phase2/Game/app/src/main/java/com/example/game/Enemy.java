package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;

class Enemy extends GameObject {

  private double r;
  private double vx;
  private double vy;

  Enemy(int x, int y, int radius, double vel_x, double vel_y) {
    super(x, y);
    r = radius;
    vx = vel_x;
    vy = vel_y;
    paint.setColor(Color.GREEN);
  }
  public double getR() {
    return r;
  }

  void draw(Canvas canvas) {
    canvas.drawCircle((float) getX(), (float) getY(), (float) r, paint);
  }

  void update(Level level){

    int elasticity = 1;

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
    }
    setX(getX() + vx);
    setY(getY() + vy);
  }
}
