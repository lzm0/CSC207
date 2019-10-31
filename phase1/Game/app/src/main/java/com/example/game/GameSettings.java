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
      case "White":
        this.color = Color.WHITE;
      case "Red":
        this.color = Color.RED;
      case "Blue":
        this.color = Color.BLUE;
      default:
        this.color = Color.WHITE;
    }
  }

  float getElasticity() {
    return elasticity;
  }

  float getSensitivity() {
    return sensitivity;
  }

  int getColor() {
    return color;
  }
}
