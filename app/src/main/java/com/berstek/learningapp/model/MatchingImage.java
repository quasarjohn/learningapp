package com.berstek.learningapp.model;

import java.io.Serializable;

public class MatchingImage implements Serializable{

  private String image;
  private String answer, chosenAnswer;

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public String getChosenAnswer() {
    return chosenAnswer;
  }

  public void setChosenAnswer(String chosenAnswer) {
    this.chosenAnswer = chosenAnswer;
  }
}
