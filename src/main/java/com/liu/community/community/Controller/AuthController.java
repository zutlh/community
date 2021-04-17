package com.liu.community.community.Controller;

import com.liu.community.community.dto.AccessTokenDTO;
import com.liu.community.community.dto.GithubUser;
import com.liu.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String ClientId;
    @Value("${github.client.secret}")
    private String ClientSecret;
    @Value("${github.redirect_uri}")
    private String redirect_uri;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) throws IOException {
        AccessTokenDTO accessTokenDto = new AccessTokenDTO();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirect_uri);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(ClientId);
        accessTokenDto.setClient_secret(ClientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
