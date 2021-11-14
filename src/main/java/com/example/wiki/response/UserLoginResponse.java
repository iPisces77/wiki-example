package com.example.wiki.response;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 付海鑫
 * @date 2021年11月12日 14:30
 */
public class UserLoginResponse implements Serializable {

  private String id;

  private String loginName;

  private String name;
  private String token;

  public UserLoginResponse() {}

  public UserLoginResponse(String id, String loginName, String name, String token) {
    this.id = id;
    this.loginName = loginName;
    this.name = name;
    this.token = token;
  }

  @Override
  public String toString() {
    return "UserLoginResponse{"
        + "id='"
        + id
        + '\''
        + ", loginName='"
        + loginName
        + '\''
        + ", name='"
        + name
        + '\''
        + ", token='"
        + token
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
        && getName().equals(that.getName())
        && getToken().equals(that.getToken());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getLoginName(), getName(), getToken());
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

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
}
