package com.example.wiki.request;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author 付海鑫
 * @date 2021年11月12日 15:59
 */
public class UserPasswordRequest implements Serializable {

  private Long id;





  @NotNull(message = "【密码】不能为空")
  // @Length(min = 6, max = 20, message = "【密码】6~20位")
  @Pattern(
      regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$",
      message = "【密码】至少包含 数字和英文，长度6-32")
  private String password;

  public UserPasswordRequest() {
  }

  public UserPasswordRequest(Long id, String password) {
    this.id = id;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "UserPasswordRequest{" +
        "id=" + id +
        ", password='" + password + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPasswordRequest that = (UserPasswordRequest) o;
    return getId().equals(that.getId()) && getPassword().equals(that.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPassword());
  }
}
