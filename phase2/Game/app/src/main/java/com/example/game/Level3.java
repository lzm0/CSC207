package com.example.game;

//import android.content.Context;

class Level3 extends Level {

  Level3(int width, int height, LevelManager levelManager) {
    super(width, height, levelManager);
  }

  void createGameObjects() {
    // Goal
    gameObjects.add(new Goal(175, 50, 40));

    // Left boundary
    gameObjects.add(new Wall(0, 0, 0, getHeight()));
    // Right boundary
    gameObjects.add(new Wall(getWidth(), 0, 0, getHeight()));
    // Top boundary
    gameObjects.add(new Wall(0, 0, getWidth(), 0));
    // Bottom boundary
    gameObjects.add(new Wall(0, getHeight(), getWidth(), 0));

    // Blackholes
    // left_1
    for (int i = 0; 50 + i < getHeight(); i += 90) {
      gameObjects.add(new Blackhole(75, 50 + i, 40));
    }

    // left_2
    for (int i = 0; 50 + i < getHeight() - 200; i += 90) {
      gameObjects.add(new Blackhole(275, 50 + i, 40));
    }

    // right_1
    for (int i = 0; 185 + i < getHeight(); i += 90) {
      gameObjects.add(new Blackhole(1000, 50 + i, 40));
    }
    // right_2
    for (int i = 0; 50 + i < getHeight() - 200; i += 90) {
      gameObjects.add(new Blackhole(800, 50 + i, 40));
    }

    // top
    for (int i = 0; 375 + i < 800; i += 110) {
      gameObjects.add(new Blackhole(375 + i, 50, 40));
    }

    // middle
    for (int i = 0; 230 + i < getHeight() - 100; i += 90) {
      gameObjects.add(new Blackhole(540, 230 + i, 40));
    }

    // bottom
    for (int i = 0; 185 + i < getWidth(); i += 90) {
      gameObjects.add(new Blackhole(165 + i, getHeight() - 60, 40));
    }

    // Ball (should be added last to prevent overlap)
    gameObjects.add(new Ball(900, 35, 30));

  }
}