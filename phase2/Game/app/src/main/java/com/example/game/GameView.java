package com.example.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("ViewConstructor")
class GameView extends SurfaceView implements SurfaceHolder.Callback {

  private LevelManager levelManager;
  private GameThread thread;

  public GameView(
      Context context, GameSettings gameSettings, UserManager userManager, GameActivity game) {
    super(context);
    getHolder().addCallback(this);
    this.thread = new GameThread(getHolder(), this);
    setFocusable(true);

    int height = Resources.getSystem().getDisplayMetrics().heightPixels;
    int width = Resources.getSystem().getDisplayMetrics().widthPixels;
    this.levelManager =
        new LevelManager(width, height, userManager, gameSettings, context, game, thread);
  }

  public void update() {
    levelManager.update();
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    thread.setRunning();
    thread.start();
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {}

  @Override
  public void draw(Canvas canvas) {
    super.draw(canvas);
    if (canvas != null) {
      levelManager.draw(canvas);
    }
  }
}
