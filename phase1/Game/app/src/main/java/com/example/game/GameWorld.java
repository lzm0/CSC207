package com.example.game;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

class GameWorld {

  List<GameObject> gameObjects;

  GameWorld() {
    gameObjects = new ArrayList<>();
  }

  void draw(Canvas canvas) {
    for (GameObject obj : gameObjects) {
      // obj.draw(canvas);
    }
  }
}
