package com.berstek.learningapp.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Module implements Serializable{

  private String moduleHeader, moduleNumber;
  private Title title;

  private List pages = new ArrayList();

  public String getModuleHeader() {
    return moduleHeader;
  }

  public void setModuleHeader(String moduleHeader) {
    this.moduleHeader = moduleHeader;
  }

  public Title getTitle() {
    return title;
  }

  public void setTitle(Title title) {
    this.title = title;
  }

  public List getPages() {
    return pages;
  }

  public void setPages(List pages) {
    this.pages = pages;
  }

  public void addPage(Object o) {
    pages.add(o);
  }

  public String getModuleNumber() {
    return moduleNumber;
  }

  public void setModuleNumber(String moduleNumber) {
    this.moduleNumber = moduleNumber;
  }
}
