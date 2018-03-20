package com.berstek.learningapp.model;

import java.io.Serializable;

public class Intro implements Serializable{

  private String imgUrl;
  private String title;
  private String header;
  private String subheader;


  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getSubheader() {
    return subheader;
  }

  public void setSubheader(String subheader) {
    this.subheader = subheader;
  }
}
