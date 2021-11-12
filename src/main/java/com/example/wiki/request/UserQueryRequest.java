package com.example.wiki.request;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 付海鑫
 * @date 2021年11月12日 14:19
 */
public class UserQueryRequest extends PageRequest implements Serializable {
  /** 登陆名 */
  private String loginName;

  public UserQueryRequest() {}

  public UserQueryRequest(String loginName) {
    this.loginName = loginName;
  }

  public UserQueryRequest(int page, int size, String loginName) {
    super(page, size);
    this.loginName = loginName;
  }

  @Override
  public String toString() {
    return "UserQueryRequest{" + "loginName='" + loginName + '\'' + "} " + super.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    UserQueryRequest that = (UserQueryRequest) o;
    return getLoginName().equals(that.getLoginName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getLoginName());
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }
}
