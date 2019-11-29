package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;


public class MagicEnemy extends GameObject {
  private double ir;
  private double fr;
  boolean goBeyond = false;


  MagicEnemy(int x, int y, int iniR, int finR) {
    super(x, y);
    ir = iniR;
    fr = finR;
    paint.setColor(Color.BLUE);
  }

  public double getIr() { return ir;
  }
  public double getFr() { return fr;

  }

  void setR(double r) {
    this.ir = r;
  }

  void draw(Canvas canvas) {
    canvas.drawCircle((float) getX(), (float) getY(), (float) ir, paint);
  }

  void update(Level level) {

    if(!goBeyond & getIr() < getFr()){
      setR(getIr() + 1);
      if (getIr() >= getFr()){
        goBeyond = true;
      }
    }
    if(goBeyond & getIr() > 40){
      setR(getIr() - 0.5);
      if(getIr() <= 40){
        goBeyond = false;
      }
    }
  }
}
