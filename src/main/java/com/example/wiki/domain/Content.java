package com.example.wiki.domain;

import java.io.Serializable;
import java.util.Objects;

/** 文档内容 */
public class Content implements Serializable {

  private static final long serialVersionUID = 1L;
  /** 文档id */
  private Long id;
  /** 内容 */
  private String content;

  public Content() {}

  public Content(Long id, String content) {
    this.id = id;
    this.content = content;
  }

  @Override
  public String toString() {
    return "Content{" + "id=" + id + ", content='" + content + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Content content1 = (Content) o;
    return getId().equals(content1.getId()) && getContent().equals(content1.getContent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getContent());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
