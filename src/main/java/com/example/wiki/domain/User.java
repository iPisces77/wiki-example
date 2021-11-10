package com.example.wiki.domain;

import java.io.Serializable;
import java.util.Objects;

/** 用户 */
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  /** ID */
  private Long id;
  /** 登陆名 */
  private String loginName;
  /** 昵称 */
  private String name;
  /** 密码 */
  private String password;

  public User(Long id) {
    this.id = id;
  }

  public User(Long id, String loginName, String name, String password) {
    this.id = id;
    this.loginName = loginName;
    this.name = name;
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{"
        + "id="
        + id
        + ", loginName='"
        + loginName
        + '\''
        + ", name='"
        + name
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return getId().equals(user.getId())
        && getLoginName().equals(user.getLoginName())
        && getName().equals(user.getName())
        && getPassword().equals(user.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getLoginName(), getName(), getPassword());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
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
