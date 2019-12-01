package com.example.game;

import android.graphics.Color;

class GameSettings {

  private double elasticity;
  private double sensitivity;
  private int color;

  GameSettings() {}

  void setElasticity(double elasticity) {
    this.elasticity = elasticity;
  }

  void setSensitivity(double sensitivity) {
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

  double getElasticity() {
    return elasticity;
  }

  double getSensitivity() {
    return 0.1 + sensitivity;
  }

  int getColor() {
    return color;
  }
}
