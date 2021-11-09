package com.example.wiki.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 文档
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doc implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 电子书id
    */
    private Long ebookId;

    /**
    * 父id
    */
    private Long parent;

    /**
    * 名称
    */
    private String name;

    /**
    * 顺序
    */
    private Integer sort;

    /**
    * 阅读数
    */
    private Integer viewCount;

    /**
    * 点赞数
    */
    private Integer voteCount;

    private static final long serialVersionUID = 1L;
}