package com.berstek.learningapp.model;

import java.io.Serializable;

public class Title implements Serializable {

  private String title, subtitle, imgUrl;
  private String moduleHeader, moduleNumber;


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getModuleHeader() {
    return moduleHeader;
  }

  public void setModuleHeader(String moduleHeader) {
    this.moduleHeader = moduleHeader;
  }

  public String getModuleNumber() {
    return moduleNumber;
  }

  public void setModuleNumber(String moduleNumber) {
    this.moduleNumber = moduleNumber;
  }
}
