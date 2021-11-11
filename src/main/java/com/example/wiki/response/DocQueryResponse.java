package com.example.wiki.response;

import java.io.Serializable;
import java.util.Objects;

/** 文档 */
public class DocQueryResponse implements Serializable {

  private static final long serialVersionUID = 1L;
  /** id */
  private String id;
  /** 电子书id */
  private Long ebookId;
  /** 父id */
  private Long parent;
  /** 名称 */
  private String name;
  /** 顺序 */
  private Integer sort;
  /** 阅读数 */
  private Integer viewCount;
  /** 点赞数 */
  private Integer voteCount;

  public DocQueryResponse() {}

  public DocQueryResponse(
      String id,
      Long ebookId,
      Long parent,
      String name,
      Integer sort,
      Integer viewCount,
      Integer voteCount) {
    this.id = id;
    this.ebookId = ebookId;
    this.parent = parent;
    this.name = name;
    this.sort = sort;
    this.viewCount = viewCount;
    this.voteCount = voteCount;
  }

  @Override
  public String toString() {
    return "Doc{"
        + "id="
        + id
        + ", ebookId="
        + ebookId
        + ", parent="
        + parent
        + ", name='"
        + name
        + '\''
        + ", sort="
        + sort
        + ", viewCount="
        + viewCount
        + ", voteCount="
        + voteCount
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
    DocQueryResponse doc = (DocQueryResponse) o;
    return getId().equals(doc.getId())
        && getEbookId().equals(doc.getEbookId())
        && getParent().equals(doc.getParent())
        && getName().equals(doc.getName())
        && getSort().equals(doc.getSort())
        && getViewCount().equals(doc.getViewCount())
        && getVoteCount().equals(doc.getVoteCount());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getId(), getEbookId(), getParent(), getName(), getSort(), getViewCount(), getVoteCount());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getEbookId() {
    return ebookId;
  }

  public void setEbookId(Long ebookId) {
    this.ebookId = ebookId;
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

  public Integer getViewCount() {
    return viewCount;
  }

  public void setViewCount(Integer viewCount) {
    this.viewCount = viewCount;
  }

  public Integer getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(Integer voteCount) {
    this.voteCount = voteCount;
  }
}
