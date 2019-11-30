package com.example.game;

//import android.content.Context;

class Level2 extends Level {

  Level2(int width, int height, LevelManager levelManager) {
    super(width, height, levelManager);
  }

  void createGameObjects() {
    // Goal
    gameObjects.add(new Goal(100, 3*getHeight()/4 + 100, 40));

    // Left boundary
    gameObjects.add(new Wall(0, 0, 0, getHeight()));
    // Right boundary
    gameObjects.add(new Wall(getWidth(), 0, 0, getHeight()));
    // Top boundary
    gameObjects.add(new Wall(0, 0, getWidth(), 0));
    // Bottom boundary
    gameObjects.add(new Wall(0, getHeight(), getWidth(), 0));

    // Walls
    gameObjects.add(new Wall(0, getHeight()/4, 17*getWidth()/24, 0));
    gameObjects.add(new Wall(0, 3*getHeight()/4, 17*getWidth()/24, 0));
    gameObjects.add(new Wall(7*getWidth()/24, getHeight()/2, 17*getWidth()/24, 0));

    // BlackHole
    gameObjects.add(new BlackHole(100, 80, 40));
    gameObjects.add(new BlackHole(830, 500, 40));
    gameObjects.add(new BlackHole(80, 600, 40));
    gameObjects.add(new BlackHole(250, 1000, 40));
    gameObjects.add(new BlackHole(80, 1400, 40));
    gameObjects.add(new BlackHole(830, 1500, 40));
    gameObjects.add(new BlackHole(1000, getHeight() - 100, 40));
    gameObjects.add(new BlackHole(100, getHeight() - 150, 40));

    // Coin
    gameObjects.add(new Coin(200, 100));
    gameObjects.add(new Coin(getWidth() - 100, 100));
    gameObjects.add(new Coin(700, 650));
    gameObjects.add(new Coin(350, 1150));
    gameObjects.add(new Coin(100, getHeight() - 230));

    // Ball (should be added last to prevent overlap)
    gameObjects.add(new Ball(500, 300, 30));

    // Enemy
    gameObjects.add(new Enemy(getWidth() - 100, 500, 0, -15, 35));
    gameObjects.add(new Enemy(500, 1700, 0, -13, 35));
  }
}

