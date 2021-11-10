package com.example.wiki.request;

import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class PageRequest {
  @NotNull(message = "【页码】不能为空")
  private int page;

  @NotNull(message = "【每页条数】不能为空")
  @Max(value = 1000, message = "【每页条数】不能超过1000")
  private int size;

  public PageRequest() {}

  public PageRequest(int page, int size) {
    this.page = page;
    this.size = size;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "PageRequest{" + "page=" + page + ", size=" + size + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageRequest that = (PageRequest) o;
    return getPage() == that.getPage() && getSize() == that.getSize();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPage(), getSize());
  }
}
