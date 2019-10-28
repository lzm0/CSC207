package com.example.game;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

class GameManager {

  List<GameObject> gameObjects;

  GameManager() {
    gameObjects = new ArrayList<>();
  }

  void draw(Canvas canvas) {
    for (GameObject obj : gameObjects) {
      // obj.draw(canvas);
    }
  }
}
