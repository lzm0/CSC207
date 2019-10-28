package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class GameView extends SurfaceView implements SurfaceHolder.Callback {

  private GameManager gameManager;
  private GameThread thread;

  public GameView(Context context) {
    super(context);
    getHolder().addCallback(this);
  }

  public void update() {
    // TODO
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    setBackgroundColor(Color.BLACK);
    thread.setRunning(true);
    thread.start();
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
  }

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
      // gameManager.draw(canvas);
      // TODO
    }
  }
}
