package com.example.game;

//import android.content.Context;

class Level3 extends Level {

  Level3(int width, int height, LevelManager levelManager) {
    super(width, height, levelManager);
  }

  void createGameObjects() {
    // Goal
    gameObjects.add(new Goal(getWidth()/3, 50, 40));

    // Left boundary
    gameObjects.add(new Wall(0, 0, 0, getHeight()));
    // Right boundary
    gameObjects.add(new Wall(getWidth(), 0, 0, getHeight()));
    // Top boundary
    gameObjects.add(new Wall(0, 0, getWidth(), 0));
    // Bottom boundary
    gameObjects.add(new Wall(0, getHeight(), getWidth(), 0));

    // Walls
    gameObjects.add(new Wall(getWidth()/3, 90, 0,4*getHeight()/5));//1

    gameObjects.add(new Wall(getWidth()/3+130,130+4*getHeight()/5, 1000,0 ));//2

    gameObjects.add(new Wall(getWidth()/3, 5*getHeight()/7, 500,0));//3
    gameObjects.add(new Wall(getWidth()/3, 2*getHeight()/7, 350,0));//4

    gameObjects.add(new Wall(2*getWidth()/3-50, 4*getHeight()/7, 500,0));//5

    gameObjects.add(new Wall(getWidth()/3+200, 3*getHeight()/7, 0,300));//6
    gameObjects.add(new Wall(getWidth()/3+350, 2*getHeight()/7, 0,300));//7
    gameObjects.add(new Wall(getWidth()/3+500, 3*getHeight()/7, 0,290));//8

    gameObjects.add(new Wall(getWidth()/3+600, 2*getHeight()/7-150, 0,400));//9

    gameObjects.add(new Wall(getWidth()/3+250, getHeight()/7, 350,0));//10

    gameObjects.add(new Wall(getWidth()/3+125, 0, 0,getHeight()/7+200));//11

    gameObjects.add(new Wall(getWidth()/3+250, 90, 0,200));//12
    gameObjects.add(new Wall(getWidth()/3+425, 0, 0,200));//13
    gameObjects.add(new Wall(getWidth()/3+600, 90, 0,200));//14



    // Blackholes
    gameObjects.add(new Blackhole(getWidth()/3,130+4*getHeight()/5,40));

    for (int i = 0; i < getWidth(); i += 100) {
      gameObjects.add(new Blackhole(getWidth() / 3 + 170 + i, 80 + 4 * getHeight() / 5, 50));
    }
    for (int i = 0; i < getWidth()-550; i += 100) {
      gameObjects.add(new Blackhole(getWidth()/3+50+i,5*getHeight()/7+50,50));
    }

    gameObjects.add(new Blackhole(getWidth()/3+155,3*getHeight()/7+50,40));
    gameObjects.add(new Blackhole(getWidth()/3+50,4*getHeight()/7,40));

    gameObjects.add(new Blackhole(getWidth()-50,4*getHeight()/7+50,40));

    gameObjects.add(new Blackhole(getWidth()/3+50,2*getHeight()/7+50,40));

    gameObjects.add(new Blackhole(getWidth()/3+450,3*getHeight()/7+240,40));
    gameObjects.add(new Blackhole(getWidth()/3+550,3*getHeight()/7+240,40));

    gameObjects.add(new Blackhole(getWidth()/3+600,2*getHeight()/7-220,60));

    gameObjects.add(new Blackhole(getWidth()/3+475,50,40));
    gameObjects.add(new Blackhole(getWidth()/3+550,240,40));
    gameObjects.add(new Blackhole(getWidth()/3+375,50,40));

    // Ball (should be added last to prevent overlap)
    gameObjects.add(new Ball(getWidth()-100, getHeight()-100, 30));

    //Enemy
    gameObjects.add(new Enemy(0, getHeight()/7, 10, 0, 35));
    gameObjects.add(new Enemy(20,2*getHeight()/7, -9, 0, 35));
    gameObjects.add(new Enemy(50,3*getHeight()/7, 7, 0, 35));
    gameObjects.add(new Enemy(30,4*getHeight()/7, -6, 0, 35));
    gameObjects.add(new Enemy(100,5*getHeight()/7, 8, 0, 35));

    gameObjects.add(new Enemy(getWidth()/3+260,3*getHeight()/7, 0, 15, 35));

    //MagicEnemy
    gameObjects.add(new MagicEnemy(getWidth()/3+420,getHeight()/7+160,50,120));

  }
}