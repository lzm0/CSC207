package com.example.game;

import android.graphics.Canvas;

abstract class GameObject {

  int x;
  int y;

  GameObject(int x, int y) {
    this.x = x;
    this.y = y;
  }

  abstract void draw(Canvas canvas);

  abstract void update(GameManager gameManager);
}
