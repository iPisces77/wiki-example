package com.example.wiki.request;

import java.io.Serializable;

/** 分类 */
public class CategoryQueryRequest extends PageRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public String toString() {
    return "CategoryQueryRequest{} " + super.toString();
  }
}
