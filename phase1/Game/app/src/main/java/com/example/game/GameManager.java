package com.example.game;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

class GameManager {

  List<GameObject> gameObjects;
  /**
   * The number of pixels of the screen width
   */
  int width;
  /**
   * The number of pixels of the screen height
   */
  int height;

  GameManager(int width, int height) {
    this.width = width;
    this.height = height;
    this.gameObjects = new ArrayList<>();
  }

  void update() {
    for (GameObject obj : gameObjects) {
      obj.update(this);
    }
  }

  void draw(Canvas canvas) {
    for (GameObject obj : gameObjects) {
      obj.draw(canvas);
    }
  }

  void createGameObjects() {
    gameObjects.add(new Circle(1000, 500, 100));
    gameObjects.add(new Circle(1500, 500, 50));
  }
}
