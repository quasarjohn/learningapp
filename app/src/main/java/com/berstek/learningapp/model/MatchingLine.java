package com.berstek.learningapp.model;

import android.widget.ImageView;

import java.io.Serializable;

public class MatchingLine implements Serializable{

  private int x, y, x1, y1;

  private ImageView sourceImg;

  private int color;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getX1() {
    return x1;
  }

  public void setX1(int x1) {
    this.x1 = x1;
  }

  public int getY1() {
    return y1;
  }

  public void setY1(int y1) {
    this.y1 = y1;
  }

  public ImageView getSourceImg() {
    return sourceImg;
  }

  public void setSourceImg(ImageView sourceImg) {
    this.sourceImg = sourceImg;
  }

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }
}
