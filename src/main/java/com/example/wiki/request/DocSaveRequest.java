package com.example.wiki.request;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/** 文档 */
public class DocSaveRequest implements Serializable {

  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 电子书id */
  @NotNull(message = "[电子书]不能为空")
  private Long ebookId;
  /** 父id */
  @NotNull(message = "[父文档]不能为空")
  private Long parent;
  /** 名称 */
  @NotNull(message = "[名称]不能为空")
  private String name;
  /** 顺序 */
  @NotNull(message = "[顺序]不能为空")
  private Integer sort;
  /** 阅读数 */
  private Integer viewCount;
  /** 点赞数 */
  private Integer voteCount;

  @NotNull(message = "[内容]不能为空")
  private String content;

  public DocSaveRequest(
      Long id,
      Long ebookId,
      Long parent,
      String name,
      Integer sort,
      Integer viewCount,
      Integer voteCount,
      String content) {
    this.id = id;
    this.ebookId = ebookId;
    this.parent = parent;
    this.name = name;
    this.sort = sort;
    this.viewCount = viewCount;
    this.voteCount = voteCount;
    this.content = content;
  }

  public DocSaveRequest() {}

  public DocSaveRequest(
      Long id,
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
    return "DocSaveRequest{"
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
        + ", content='"
        + content
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
    DocSaveRequest that = (DocSaveRequest) o;
    return getId().equals(that.getId())
        && getEbookId().equals(that.getEbookId())
        && getParent().equals(that.getParent())
        && getName().equals(that.getName())
        && getSort().equals(that.getSort())
        && getViewCount().equals(that.getViewCount())
        && getVoteCount().equals(that.getVoteCount())
        && getContent().equals(that.getContent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getId(),
        getEbookId(),
        getParent(),
        getName(),
        getSort(),
        getViewCount(),
        getVoteCount(),
        getContent());
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
