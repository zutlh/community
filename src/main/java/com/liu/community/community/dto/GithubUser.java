package com.liu.community.community.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GithubUser {
    private String name;
    private long id;
    private String bio;
    private String avatar_url;

}
