package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;

class MagicEnemy extends GameObject {

  private double ir;
  private double fr;
  private boolean goBeyond = false;

  /**
   * Class constructor that extends GameObject.
   *
   * @param x the x-coordinate of this MagicEnemy
   * @param y the y-coordinate of this MagicEnemy
   * @param iniR the initial radius of this MagicEnemy could be
   * @param finR the maximum radius of this MagicEnemy could be
   */
  MagicEnemy(int x, int y, int iniR, int finR) {
    super(x, y);
    ir = iniR;
    fr = finR;
    paint.setColor(Color.BLUE);
  }

  double getIr() {
    return ir;
  }

  double getFr() {
    return fr;
  }

  void setR(double r) {
    this.ir = r;
  }

  void draw(Canvas canvas) {
    canvas.drawCircle((float) getX(), (float) getY(), (float) ir, paint);
  }

  /**
   * Changes the radius of this MagicEnemy. When ths current radius is less than the maximum radius
   * of this magic enemy, the current radius will become lager until no more less than the maximum.
   * Then the current radius will getting smaller until it is less than or equal to 40.
   *
   * @param level the level of this magic enemy in.
   */
  void update(Level level) {

    if (!goBeyond & getIr() < getFr()) {
      setR(getIr() + 1);
      if (getIr() >= getFr()) {
        goBeyond = true;
      }
    }
    if (goBeyond & getIr() > 40) {
      setR(getIr() - 0.5);
      if (getIr() <= 40) {
        goBeyond = false;
      }
    }
  }
}
