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

  public GameView(Context context) {
    super(context);
    getHolder().addCallback(this);
    this.thread = new GameThread(getHolder(), this);
    setFocusable(true);
    this.levelManager = new LevelManager(width, height, context);
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
    boolean retry = true;
    while (retry) {
      try {
        thread.setRunning(false);
        thread.join();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      retry = false;
    }
  }

  @Override
  public void draw(Canvas canvas) {
    super.draw(canvas);
    if (canvas != null) {
      levelManager.draw(canvas);
    }
  }
}