package com.liu.community.community.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String account;
    private String token;
    private long gmtCreate;
    private long gmtModified;
    private String avatarUrl;

}
