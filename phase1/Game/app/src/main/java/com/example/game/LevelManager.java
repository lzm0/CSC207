package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

class LevelManager {

  private List<Level> levels;
  private int currentLevel;
  private Context context;

  LevelManager(int width, int height, Context context) {
    this.context = context;
    this.levels = new ArrayList<>();
    levels.add(new Level1(width, height, this));
    levels.add(new Level2(width, height, this));
    levels.add(new Level3(width, height, this));

    currentLevel = 1;
    levels.get(currentLevel - 1).start();
  }

  void finishLevel() {
    if (currentLevel < levels.size()) {
      currentLevel++;
      levels.get(currentLevel - 1).start();
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
