package com.example.wiki.request;

import java.io.Serializable;
import java.util.Objects;

/** 电子书 */
public class EBookQueryRequest extends PageRequest implements Serializable {
  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 名称 */
  private String name;

  private Long category2Id;

  public EBookQueryRequest(Long id, String name, Long category2Id) {
    this.id = id;
    this.name = name;
    this.category2Id = category2Id;
  }

  public EBookQueryRequest(int page, int size, Long id, String name, Long category2Id) {
    super(page, size);
    this.id = id;
    this.name = name;
    this.category2Id = category2Id;
  }

  public EBookQueryRequest() {}

  public EBookQueryRequest(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "EBookQueryRequest{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", category2Id="
        + category2Id
        + "} "
        + super.toString();
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
    EBookQueryRequest that = (EBookQueryRequest) o;
    return getId().equals(that.getId())
        && getName().equals(that.getName())
        && getCategoryId2().equals(that.getCategoryId2());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getId(), getName(), getCategoryId2());
  }

  public Long getCategoryId2() {
    return category2Id;
  }

  public void setCategoryId2(Long category2Id) {
    this.category2Id = category2Id;
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
}
