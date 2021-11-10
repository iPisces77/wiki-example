package com.example.wiki.domain;

import java.io.Serializable;
import java.util.Objects;

/** 测试 */
public class Test implements Serializable {

  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 名称 */
  private String name;
  /** 密码 */
  private String password;

  public Test() {}

  public Test(Long id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  @Override
  public String toString() {
    return "Test{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Test test = (Test) o;
    return getId().equals(test.getId())
        && getName().equals(test.getName())
        && getPassword().equals(test.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getPassword());
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
