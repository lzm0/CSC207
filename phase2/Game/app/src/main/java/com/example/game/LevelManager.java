package com.example.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

class LevelManager {

  private List<Level> levels;
  private int currentLevel;
  private Context context;
  private UserManager userManager;
  GameSettings gameSettings;
    private GameActivity game;
    private GameThread thread;

    LevelManager(int width, int height, UserManager userManager, GameSettings gameSettings,
                 Context context, GameActivity game, GameThread thread) {
    this.context = context;
    this.levels = new ArrayList<>();
        this.levels.add(new Level1(width, height, this));
        this.levels.add(new Level2(width, height, this));
        this.levels.add(new Level3(width, height, this));

    this.userManager = userManager;
    this.gameSettings = gameSettings;
        this.game = game;
        this.thread = thread;

    currentLevel = userManager.getUserInfo(context);
    levels.get(currentLevel - 1).start();
  }

  void finishLevel(Context context) {
      if (currentLevel < levels.size()) {
          currentLevel++;
          levels.get(currentLevel - 1).start();
          userManager.setUserInfo(context, currentLevel);
      } else {
          userManager.setUserInfo(context, 1);
          this.thread.closeRunning();
          Intent intent = new Intent(context, BonusActivity.class);
          intent.putExtra("Username", userManager.getUsername());
          game.startActivity(intent);

      }
  }

  Context getContext() {
    return context;
  }

  void update() {
    levels.get(currentLevel - 1).update();
  }

  void draw(Canvas canvas) {
    levels.get(currentLevel - 1).draw(canvas);
  }
}
