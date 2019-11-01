package com.example.game;

import android.graphics.Color;

class GameSettings {

  private float elasticity;
  private float sensitivity;
  private int color;

  GameSettings() {
  }

  void setElasticity(float elasticity) {
    this.elasticity = elasticity;
  }

  void setSensitivity(float sensitivity) {
    this.sensitivity = sensitivity;
  }

  void setColor(String colorName) {
    switch (colorName) {
      case "Red":
        this.color = Color.RED;
        break;
      case "Blue":
        this.color = Color.BLUE;
        break;
      default:
        this.color = Color.WHITE;
    }
  }

  float getElasticity() {
    return elasticity;
  }

  float getSensitivity() {
    return 0.1f + sensitivity;
  }

  int getColor() {
    return color;
  }
}
