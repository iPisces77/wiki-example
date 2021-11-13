package com.example.wiki.response;

import java.util.Objects;

/**
 * @author 付海鑫
 * @date 2021年11月12日 14:30
 */
public class UserLoginResponse {

  private String id;

  private String loginName;

  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public String toString() {
    return "Use  @OverriderLoginResponse{"
        + "id="
        + id
        + ", loginName='"
        + loginName
        + '\''
        + ", name='"
        + name
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
    UserLoginResponse that = (UserLoginResponse) o;
    return getId().equals(that.getId())
        && getLoginName().equals(that.getLoginName())
        && getName().equals(that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getLoginName(), getName());
  }
}
