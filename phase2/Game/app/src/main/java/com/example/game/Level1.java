package com.example.game;

// import android.content.Context;

class Level1 extends Level {

  Level1(int width, int height, LevelManager levelManager) {
    super(width, height, levelManager);
  }

  void createGameObjects() {
    // Goal
    gameObjects.add(new Goal(550, 5 * getHeight() / 7 - 80, 40));

    // Left boundary
    gameObjects.add(new Wall(0, 0, 0, getHeight()));
    // Right boundary
    gameObjects.add(new Wall(getWidth(), 0, 0, getHeight()));
    // Top boundary
    gameObjects.add(new Wall(0, 0, getWidth(), 0));
    // Bottom boundary
    gameObjects.add(new Wall(0, getHeight(), getWidth(), 0));

    // Walls
    gameObjects.add(new Wall(getWidth() / 5, 0, 0, 6 * getHeight() / 7));
    gameObjects.add(new Wall(getWidth() / 5, 6 * getHeight() / 7, 3 * getWidth() / 5, 0));
    gameObjects.add(new Wall(4 * getWidth() / 5, getHeight() / 7, 0, 5 * getHeight() / 7));
    gameObjects.add(new Wall(2 * getWidth() / 5, getHeight() / 7, 2 * getWidth() / 5, 0));
    gameObjects.add(new Wall(2 * getWidth() / 5, getHeight() / 7, 0, 4 * getHeight() / 7));
    gameObjects.add(new Wall(2 * getWidth() / 5, 5 * getHeight() / 7, getWidth() / 5, 0));
    gameObjects.add(new Wall(3 * getWidth() / 5, 2 * getHeight() / 7, 0, 3 * getHeight() / 7));

    // Coins
    gameObjects.add(new Coin(200, getHeight() - 200));
    gameObjects.add(new Coin(850, getHeight() - 200));
    gameObjects.add(new Coin(880, 250));
    gameObjects.add(new Coin(420, 250));
    gameObjects.add(new Coin(420, 6 * getHeight() / 7 - 200));
    gameObjects.add(new Coin(720, 6 * getHeight() / 7 - 200));
    gameObjects.add(new Coin(3 * getWidth() / 5, 2 * getHeight() / 7 - 80));

    // Blackholes
    gameObjects.add(new BlackHole(100, getHeight() - 100, 40));
    gameObjects.add(new BlackHole(950, getHeight() - 100, 40));
    gameObjects.add(new BlackHole(950, 150, 40));
    gameObjects.add(new BlackHole(350, 150, 40));
    gameObjects.add(new BlackHole(350, 6 * getHeight() / 7 - 100, 40));
    gameObjects.add(new BlackHole(750, 6 * getHeight() / 7 - 100, 40));
    gameObjects.add(new BlackHole(750, 450, 40));
    gameObjects.add(new BlackHole(550, 450, 40));

    // Ball (should be added last to prevent overlap)
    gameObjects.add(new Ball(50, 30, 30));
  }
}
