package com.example.wiki.response;

import java.util.Objects;

/**
 * @author 付海鑫
 * @date 2021年11月09日 16:02
 */
public class CommonResponse<T> {

  /** 业务上的成功或失败 */
  private boolean success = true;

  /** 返回信息 */
  private String message;

  /** 返回泛型数据，自定义类型 */
  private T content;

  public CommonResponse() {}

  public CommonResponse(boolean success, String message, T content) {
    this.success = success;
    this.message = message;
    this.content = content;
  }



  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonResponse<?> that = (CommonResponse<?>) o;
    return isSuccess() == that.isSuccess()
        && getMessage().equals(that.getMessage())
        && getContent().equals(that.getContent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(isSuccess(), getMessage(), getContent());
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  @Override
  public String toString() {
    return "ResponseDto{"
        + "success="
        + success
        + ", message='"
        + message
        + '\''
        + ", content="
        + content
        + '}';
  }
}
