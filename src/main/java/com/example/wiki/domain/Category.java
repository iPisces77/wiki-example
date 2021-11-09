package com.example.wiki.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 分类
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    /**
    * id
    */
    private Long id;

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

    private static final long serialVersionUID = 1L;
}