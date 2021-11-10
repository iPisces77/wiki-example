package com.example.wiki.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/** 电子书快照表 */
public class EbookSnapshot implements Serializable {

  private static final long serialVersionUID = 1L;
  /** id */
  private Long id;
  /** 电子书id */
  private Long ebookId;
  /** 快照日期 */
  private Date date;
  /** 阅读数 */
  private Integer viewCount;
  /** 点赞数 */
  private Integer voteCount;
  /** 阅读增长 */
  private Integer viewIncrease;
  /** 点赞增长 */
  private Integer voteIncrease;

  public EbookSnapshot() {}

  public EbookSnapshot(
      Long id,
      Long ebookId,
      Date date,
      Integer viewCount,
      Integer voteCount,
      Integer viewIncrease,
      Integer voteIncrease) {
    this.id = id;
    this.ebookId = ebookId;
    this.date = date;
    this.viewCount = viewCount;
    this.voteCount = voteCount;
    this.viewIncrease = viewIncrease;
    this.voteIncrease = voteIncrease;
  }

  @Override
  public String toString() {
    return "EbookSnapshot{"
        + "id="
        + id
        + ", ebookId="
        + ebookId
        + ", date="
        + date
        + ", viewCount="
        + viewCount
        + ", voteCount="
        + voteCount
        + ", viewIncrease="
        + viewIncrease
        + ", voteIncrease="
        + voteIncrease
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
    EbookSnapshot that = (EbookSnapshot) o;
    return getId().equals(that.getId())
        && getEbookId().equals(that.getEbookId())
        && getDate().equals(that.getDate())
        && getViewCount().equals(that.getViewCount())
        && getVoteCount().equals(that.getVoteCount())
        && getViewIncrease().equals(that.getViewIncrease())
        && getVoteIncrease().equals(that.getVoteIncrease());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getId(),
        getEbookId(),
        getDate(),
        getViewCount(),
        getVoteCount(),
        getViewIncrease(),
        getVoteIncrease());
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
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

  public Integer getViewIncrease() {
    return viewIncrease;
  }

  public void setViewIncrease(Integer viewIncrease) {
    this.viewIncrease = viewIncrease;
  }

  public Integer getVoteIncrease() {
    return voteIncrease;
  }

  public void setVoteIncrease(Integer voteIncrease) {
    this.voteIncrease = voteIncrease;
  }
}
