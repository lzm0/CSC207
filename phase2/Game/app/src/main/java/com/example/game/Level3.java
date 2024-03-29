package com.example.game;

// import android.content.Context;

class Level3 extends Level {

  Level3(int width, int height, LevelManager levelManager) {
    super(width, height, levelManager);
  }

  void createGameObjects() {
    // Goal
    gameObjects.add(new Goal(getWidth() / 3, 50, 40));

    // Left boundary
    gameObjects.add(new Wall(0, 0, 0, getHeight()));
    // Right boundary
    gameObjects.add(new Wall(getWidth(), 0, 0, getHeight()));
    // Top boundary
    gameObjects.add(new Wall(0, 0, getWidth(), 0));
    // Bottom boundary
    gameObjects.add(new Wall(0, getHeight(), getWidth(), 0));

    // Walls
    gameObjects.add(new Wall(getWidth() / 3, 90, 0, 4 * getHeight() / 5)); // 1

    gameObjects.add(new Wall(getWidth() / 3 + 130, 130 + 4 * getHeight() / 5, 1000, 0)); // 2

    gameObjects.add(new Wall(getWidth() / 3, 5 * getHeight() / 7, 500, 0)); // 3
    gameObjects.add(new Wall(getWidth() / 3, 2 * getHeight() / 7, 350, 0)); // 4

    gameObjects.add(new Wall(2 * getWidth() / 3 - 50, 4 * getHeight() / 7, 500, 0)); // 5

    gameObjects.add(new Wall(getWidth() / 3 + 200, 3 * getHeight() / 7, 0, 300)); // 6
    gameObjects.add(new Wall(getWidth() / 3 + 350, 2 * getHeight() / 7, 0, 300)); // 7
    gameObjects.add(new Wall(getWidth() / 3 + 500, 3 * getHeight() / 7, 0, 290)); // 8

    gameObjects.add(new Wall(getWidth() / 3 + 600, 2 * getHeight() / 7 - 150, 0, 400)); // 9

    gameObjects.add(new Wall(getWidth() / 3 + 250, getHeight() / 7, 350, 0)); // 10

    gameObjects.add(new Wall(getWidth() / 3 + 125, 0, 0, getHeight() / 7 + 200)); // 11

    gameObjects.add(new Wall(getWidth() / 3 + 250, 90, 0, 200)); // 12
    gameObjects.add(new Wall(getWidth() / 3 + 425, 0, 0, 200)); // 13
    gameObjects.add(new Wall(getWidth() / 3 + 600, 90, 0, 200)); // 14

    // Coins
    for (int i = 0; i < 300; i += 60) {
      gameObjects.add(new Coin(60 + i, getHeight() / 14));
    }
    gameObjects.add(new Coin(200, getHeight() / 7 + 150)); // 5 times
    gameObjects.add(new Coin(200, getHeight() / 7 + 150));
    gameObjects.add(new Coin(200, getHeight() / 7 + 150));
    gameObjects.add(new Coin(200, getHeight() / 7 + 150));
    gameObjects.add(new Coin(200, getHeight() / 7 + 150));
    gameObjects.add(new Coin(140, 2 * getHeight() / 7 + 150));
    gameObjects.add(new Coin(250, 3 * getHeight() / 7 + 150));
    gameObjects.add(new Coin(210, 4 * getHeight() / 7 + 150));

    gameObjects.add(new Coin(2 * getWidth() / 3, 22 * getHeight() / 25)); // ?
    gameObjects.add(new Coin(2 * getWidth() / 3 - 45, 22 * getHeight() / 25 + 20));
    gameObjects.add(new Coin(2 * getWidth() / 3 - 80, 22 * getHeight() / 25 + 60));
    gameObjects.add(new Coin(2 * getWidth() / 3 + 45, 22 * getHeight() / 25 + 20));
    gameObjects.add(new Coin(2 * getWidth() / 3 + 80, 22 * getHeight() / 25 + 60));
    gameObjects.add(new Coin(2 * getWidth() / 3 + 45, 22 * getHeight() / 25 + 100));
    gameObjects.add(new Coin(2 * getWidth() / 3 + 15, 22 * getHeight() / 25 + 150));
    gameObjects.add(new Coin(2 * getWidth() / 3, 22 * getHeight() / 25 + 220));

    for (int i = 0; i < 500; i += 100) {
      gameObjects.add(new Coin(getWidth() / 2 + i, 7.9 * getHeight() / 10));
    }

    gameObjects.add(new Coin(getWidth() / 3 + 155, 3 * getHeight() / 7 + 130));
    gameObjects.add(new Coin(getWidth() / 3 + 260, 3 * getHeight() / 7 - 150));
    gameObjects.add(new Coin(getWidth() - 50, 4 * getHeight() / 7 + 130));

    gameObjects.add(new Coin(getWidth() / 3 + 260, 4 * getHeight() / 7));
    gameObjects.add(new Coin(getWidth() / 3 + 360, 4 * getHeight() / 7 - 100));
    gameObjects.add(new Coin(getWidth() / 3 + 460, 4 * getHeight() / 7 - 200));

    gameObjects.add(new Coin(getWidth() / 3 + 690, 2 * getHeight() / 7 - 220));
    gameObjects.add(new Coin(getWidth() / 3 + 550, 170));

    gameObjects.add(new Coin(getWidth() / 3 + 420, getHeight() / 7 + 40));
    gameObjects.add(new Coin(getWidth() / 3 + 520, getHeight() / 7 + 110));
    gameObjects.add(new Coin(getWidth() / 3 + 560, getHeight() / 7 + 200));
    gameObjects.add(new Coin(getWidth() / 3 + 380, 2 * getHeight() / 7 - 30));
    gameObjects.add(new Coin(getWidth() / 3 + 420, 2 * getHeight() / 7 + 60));
    gameObjects.add(new Coin(getWidth() / 3 + 300, 2 * getHeight() / 7 - 80));

    // Blackholes
    gameObjects.add(new BlackHole(getWidth() / 3, 130 + 4 * getHeight() / 5, 40));

    for (int i = 0; i < getWidth(); i += 100) {
      gameObjects.add(new BlackHole(getWidth() / 3 + 170 + i, 80 + 4 * getHeight() / 5, 50));
    }
    for (int i = 0; i < getWidth() - 550; i += 100) {
      gameObjects.add(new BlackHole(getWidth() / 3 + 50 + i, 5 * getHeight() / 7 + 50, 50));
    }

    gameObjects.add(new BlackHole(getWidth() / 3 + 155, 3 * getHeight() / 7 + 50, 40));
    gameObjects.add(new BlackHole(getWidth() / 3 + 50, 4 * getHeight() / 7, 40));

    gameObjects.add(new BlackHole(getWidth() - 50, 4 * getHeight() / 7 + 50, 40));

    gameObjects.add(new BlackHole(getWidth() / 3 + 50, 2 * getHeight() / 7 + 50, 40));

    gameObjects.add(new BlackHole(getWidth() / 3 + 450, 3 * getHeight() / 7 + 240, 40));
    gameObjects.add(new BlackHole(getWidth() / 3 + 550, 3 * getHeight() / 7 + 240, 40));

    gameObjects.add(new BlackHole(getWidth() / 3 + 600, 2 * getHeight() / 7 - 220, 60));

    gameObjects.add(new BlackHole(getWidth() / 3 + 475, 50, 40));
    gameObjects.add(new BlackHole(getWidth() / 3 + 550, 240, 40));
    gameObjects.add(new BlackHole(getWidth() / 3 + 375, 50, 40));

    // Enemy
    gameObjects.add(new Enemy(0, getHeight() / 7, 10, 0, 35));
    gameObjects.add(new Enemy(20, 2 * getHeight() / 7, -9, 0, 35));
    gameObjects.add(new Enemy(50, 3 * getHeight() / 7, 7, 0, 35));
    gameObjects.add(new Enemy(30, 4 * getHeight() / 7, -6, 0, 35));
    gameObjects.add(new Enemy(100, 5 * getHeight() / 7, 8, 0, 35));

    gameObjects.add(new Enemy(getWidth() / 3 + 260, 3 * getHeight() / 7, 0, 15, 35));

    // MagicEnemy
    gameObjects.add(new MagicEnemy(getWidth() / 3 + 420, getHeight() / 7 + 160, 50, 120));
    gameObjects.add(new MagicEnemy(getWidth() / 7, 8 * getHeight() / 9, 99, 100));

    // Ball (should be added last to prevent overlap)
    gameObjects.add(new Ball(getWidth() - 100, getHeight() - 100, 30));
  }
}
