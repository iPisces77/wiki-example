package com.example.wiki.domain;

import java.io.Serializable;
import java.util.Objects;

/** 测试 */
public class Demo implements Serializable {

  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 名称 */
  private String name;

  public Demo() {}

  public Demo(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Demo{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Demo demo = (Demo) o;
    return getId().equals(demo.getId()) && getName().equals(demo.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
