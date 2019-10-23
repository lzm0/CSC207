package com.example.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

  private GameView gameView;
  private SurfaceHolder surfaceHolder;
  private boolean isRunning;
  public static Canvas canvas;

  public GameThread(SurfaceHolder surfaceHolder, GameView view) {
    this.surfaceHolder = surfaceHolder;
    this.gameView = view;
  }

  @Override
  public void run() {
    while (isRunning) {
      canvas = null;

      try {
        canvas = this.surfaceHolder.lockCanvas();
        synchronized (surfaceHolder) {
          this.gameView.update();
          this.gameView.draw(canvas);
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        if (canvas != null) {
          try {
            surfaceHolder.unlockCanvasAndPost(canvas);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }

      try {
        this.sleep(16);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void setRunning(boolean isRunning) {
    this.isRunning = isRunning;
  }
}
