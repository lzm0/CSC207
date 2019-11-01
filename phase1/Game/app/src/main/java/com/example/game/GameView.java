package com.example.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class GameView extends SurfaceView implements SurfaceHolder.Callback {

  /**
   * Screen width.
   */
  private int width = Resources.getSystem().getDisplayMetrics().widthPixels;
  /**
   * Screen height.
   */
  private int height = Resources.getSystem().getDisplayMetrics().heightPixels;

  private LevelManager levelManager;
  private GameThread thread;

  public GameView(Context context, GameSettings gameSettings, UserManager userManager) {
    super(context);
    getHolder().addCallback(this);
    this.thread = new GameThread(getHolder(), this);
    setFocusable(true);

    this.levelManager = new LevelManager(width, height, userManager, gameSettings, context);
  }

  public void update() {
    levelManager.update();
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    thread.setRunning(true);
    thread.start();
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
  }

  @Override
  public void draw(Canvas canvas) {
    super.draw(canvas);
    if (canvas != null) {
      levelManager.draw(canvas);
    }
  }
}