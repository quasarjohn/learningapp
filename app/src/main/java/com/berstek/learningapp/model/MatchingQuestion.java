package com.berstek.learningapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatchingQuestion implements Serializable {

  private List<MatchingImage> matchingImages = new ArrayList<>();
  private List<String> choices = new ArrayList<>();

  public List<String> getChoices() {
    return choices;
  }

  public void setChoices(List<String> choices) {
    this.choices = choices;
  }

  public List<MatchingImage> getMatchingImages() {
    return matchingImages;
  }

  public void setMatchingImages(List<MatchingImage> matchingImages) {
    this.matchingImages = matchingImages;
  }

  public void addMatchingImage(MatchingImage image) {
    matchingImages.add(image);
  }

  public void addChoice(String choice) {
    choices.add(choice);
  }
}
