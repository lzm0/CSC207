package com.example.game;

import android.graphics.Canvas;
import android.graphics.Paint;

abstract class GameObject {

  private double x;
  private double y;
  Paint paint;

  /**
   * Class constructor specifying the x-coordinate and y-coordinate to create.
   *
   * @param x   the x-coordinate of this GameObject
   * @param y   the y-coordinate of this GameObject
   */
  GameObject(double x, double y) {
    this.x = x;
    this.y = y;
    paint = new Paint();
  }

  /**
   * Gets the x-coordinate of this GameObject.
   *
   * @return   the x-coordinate x of this GameObject
   */
  double getX() {
    return x;
  }

  /**
   * Changes the private attribute x to a new value.
   *
   * @param x   the new value of x-coordinate.
   */
  void setX(double x) {
    this.x = x;
  }

  /**
   * Gets the y-coordinate of this GameObject.
   *
   * @return   the y-coordinate y of this GameObject.
   */
  double getY() {
    return y;
  }

  /**
   * Changes the private attribute y to a new value.
   *
   * @param y   the new value of y-coordinate.
   */
  void setY(double y) {
    this.y = y;
  }

  abstract void draw(Canvas canvas);

  abstract void update(Level level);
}
