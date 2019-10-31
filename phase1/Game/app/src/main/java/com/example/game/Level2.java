package com.example.game;

import android.content.Context;

class Level2 extends Level {

  Level2(int width, int height, Context context) {
    super(width, height, context);
  }

  void createGameObjects() {
    // Goal
    gameObjects.add(new Goal(550, 1350, 40));

    // Left boundary
    gameObjects.add(new Wall(0, 0, 0, getHeight()));
    // Right boundary
    gameObjects.add(new Wall(getWidth(), 0, 0, getHeight()));
    // Top boundary
    gameObjects.add(new Wall(0, 0, getWidth(), 0));
    // Bottom boundary
    gameObjects.add(new Wall(0, getHeight(), getWidth(), 0));

    // Walls
    gameObjects.add(new Wall(getWidth()/5, 0, 0, 6*getHeight()/7));
    gameObjects.add(new Wall(getWidth()/5, 6*getHeight()/7, 3*getWidth()/5, 0));
    gameObjects.add(new Wall(4*getWidth()/5, getHeight()/7, 0, 5*getHeight()/7));
    gameObjects.add(new Wall(2*getWidth()/5, getHeight()/7, 2*getWidth()/5, 0));
    gameObjects.add(new Wall(2*getWidth()/5, getHeight()/7, 0, 4*getHeight()/7));
    gameObjects.add(new Wall(2*getWidth()/5, 5*getHeight()/7, getWidth()/5, 0));
    gameObjects.add(new Wall(3*getWidth()/5, 2*getHeight()/7, 0, 3*getHeight()/7));

    // Blackhole
    gameObjects.add(new Blackhole(100, 1900, 40));
    gameObjects.add(new Blackhole(950, 1900, 40));
    gameObjects.add(new Blackhole(950, 150, 40));
    gameObjects.add(new Blackhole(350, 150, 40));
    gameObjects.add(new Blackhole(350, 1600, 40));
    gameObjects.add(new Blackhole(750, 1600, 40));
    gameObjects.add(new Blackhole(750, 450, 40));
    gameObjects.add(new Blackhole(550, 450, 40));

    // Ball (should be added last to prevent overlap)
    gameObjects.add(new Ball(50, 30, 30));
  }

}
