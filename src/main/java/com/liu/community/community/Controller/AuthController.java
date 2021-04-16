package com.liu.community.community.Controller;

import com.liu.community.community.dto.AccessTokenDTO;
import com.liu.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) throws IOException {
        AccessTokenDTO accessTokenDto = new AccessTokenDTO();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id("f5f1c69b086d0ea492b1");
        accessTokenDto.setClient_secret("27eacaa1369d421ebee8dc344a62b0fadc7ba057");
        githubProvider.getAccessToken(accessTokenDto);
        return "index";
    }
}
