package com.berstek.learningapp.model;


import java.io.Serializable;

public class Question implements Serializable {

  private String image;
  private int count;
  private boolean sample;

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public boolean isSample() {
    return sample;
  }

  public void setSample(boolean sample) {
    this.sample = sample;
  }
}
