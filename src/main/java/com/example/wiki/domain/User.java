package com.example.wiki.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
    * ID
    */
    private Long id;

    /**
    * 登陆名
    */
    private String loginName;

    /**
    * 昵称
    */
    private String name;

    /**
    * 密码
    */
    private String password;

    private static final long serialVersionUID = 1L;
}