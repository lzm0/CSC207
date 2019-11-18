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
      case "Blue":
        this.color = Color.BLUE;
        break;
      case "Magenta":
        this.color = Color.MAGENTA;
        break;
      case "Cyan":
        this.color = Color.CYAN;
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