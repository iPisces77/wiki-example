package com.example.wiki.response;

import java.io.Serializable;
import java.util.Objects;

/** 分类 */
public class CategoryQueryResponse implements Serializable {

  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 父id */
  private Long parent;
  /** 名称 */
  private String name;
  /** 顺序 */
  private Integer sort;

  public CategoryQueryResponse() {}

  public CategoryQueryResponse(Long id, Long parent, String name, Integer sort) {
    this.id = id;
    this.parent = parent;
    this.name = name;
    this.sort = sort;
  }

  @Override
  public String toString() {
    return "Category{"
        + "id="
        + id
        + ", parent="
        + parent
        + ", name='"
        + name
        + '\''
        + ", sort="
        + sort
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
    CategoryQueryResponse category = (CategoryQueryResponse) o;
    return getId().equals(category.getId())
        && getParent().equals(category.getParent())
        && getName().equals(category.getName())
        && getSort().equals(category.getSort());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getParent(), getName(), getSort());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getParent() {
    return parent;
  }

  public void setParent(Long parent) {
    this.parent = parent;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }
}
