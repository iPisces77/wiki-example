package com.example.wiki.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 电子书快照表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookSnapshot implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 电子书id
    */
    private Long ebookId;

    /**
    * 快照日期
    */
    private Date date;

    /**
    * 阅读数
    */
    private Integer viewCount;

    /**
    * 点赞数
    */
    private Integer voteCount;

    /**
    * 阅读增长
    */
    private Integer viewIncrease;

    /**
    * 点赞增长
    */
    private Integer voteIncrease;

    private static final long serialVersionUID = 1L;
}