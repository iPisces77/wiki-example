package com.example.wiki.request;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author 付海鑫
 * @date 2021年11月12日 14:30
 */
public class UserLoginRequest implements Serializable {

  private Long id;

  @NotEmpty(message = "【用户名】不能为空")
  private String loginName;

  @NotEmpty(message = "【密码】不能为空")
  // @Length(min = 6, max = 20, message = "【密码】6~20位")
  @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】规则不正确")
  private String password;

  public UserLoginRequest(Long id, String loginName, String password) {
    this.id = id;
    this.loginName = loginName;
    this.password = password;
  }

  public UserLoginRequest() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "UserLoginRequest{"
        + "id="
        + id
        + ", loginName='"
        + loginName
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
    UserLoginRequest that = (UserLoginRequest) o;
    return getId().equals(that.getId())
        && getLoginName().equals(that.getLoginName())
        && getPassword().equals(that.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getLoginName(), getPassword());
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
