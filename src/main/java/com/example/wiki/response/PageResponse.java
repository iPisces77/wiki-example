package com.example.wiki.response;

import java.util.List;
import java.util.Objects;

public class PageResponse<T> {
  private long total;
  private List<T> list;

  public PageResponse() {}

  public PageResponse(long total, List<T> list) {
    this.total = total;
    this.list = list;
  }

  @Override
  public String toString() {
    return "PageResponse{" + "total=" + total + ", list=" + list + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageResponse<?> that = (PageResponse<?>) o;
    return getTotal() == that.getTotal() && getList().equals(that.getList());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTotal(), getList());
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }
}
