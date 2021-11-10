package com.example.wiki.request;

import java.io.Serializable;
import java.util.Objects;

/** 电子书 */
public class EBookSaveRequest implements Serializable {

  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 名称 */
  private String name;
  /** 分类1 */
  private Long category1Id;
  /** 分类2 */
  private Long category2Id;
  /** 描述 */
  private String description;
  /** 封面 */
  private String cover;
  /** 文档数 */
  private Integer docCount;
  /** 阅读数 */
  private Integer viewCount;
  /** 点赞数 */
  private Integer voteCount;

  public EBookSaveRequest() {}

  public EBookSaveRequest(
      Long id,
      String name,
      Long category1Id,
      Long category2Id,
      String description,
      String cover,
      Integer docCount,
      Integer viewCount,
      Integer voteCount) {
    this.id = id;
    this.name = name;
    this.category1Id = category1Id;
    this.category2Id = category2Id;
    this.description = description;
    this.cover = cover;
    this.docCount = docCount;
    this.viewCount = viewCount;
    this.voteCount = voteCount;
  }

  @Override
  public String toString() {
    return "Ebook{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", category1Id="
        + category1Id
        + ", category2Id="
        + category2Id
        + ", description='"
        + description
        + '\''
        + ", cover='"
        + cover
        + '\''
        + ", docCount="
        + docCount
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
    EBookSaveRequest ebook = (EBookSaveRequest) o;
    return getId().equals(ebook.getId())
        && getName().equals(ebook.getName())
        && getCategory1Id().equals(ebook.getCategory1Id())
        && getCategory2Id().equals(ebook.getCategory2Id())
        && getDescription().equals(ebook.getDescription())
        && getCover().equals(ebook.getCover())
        && getDocCount().equals(ebook.getDocCount())
        && getViewCount().equals(ebook.getViewCount())
        && getVoteCount().equals(ebook.getVoteCount());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getId(),
        getName(),
        getCategory1Id(),
        getCategory2Id(),
        getDescription(),
        getCover(),
        getDocCount(),
        getViewCount(),
        getVoteCount());
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

  public Long getCategory1Id() {
    return category1Id;
  }

  public void setCategory1Id(Long category1Id) {
    this.category1Id = category1Id;
  }

  public Long getCategory2Id() {
    return category2Id;
  }

  public void setCategory2Id(Long category2Id) {
    this.category2Id = category2Id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public Integer getDocCount() {
    return docCount;
  }

  public void setDocCount(Integer docCount) {
    this.docCount = docCount;
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
