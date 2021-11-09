package com.example.wiki.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 文档内容
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content implements Serializable {
    /**
    * 文档id
    */
    private Long id;

    /**
    * 内容
    */
    private String content;

    private static final long serialVersionUID = 1L;
}