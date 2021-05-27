package com.icewould.oauth2auth.controller;

import com.icewould.common.utils.CommonResult;
import com.icewould.oauth2auth.domain.Oauth2TokenDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

/**
 * @Description: Redis相关配置
 * @Author: Jerrio
 * @Date: 5/21/21 4:47 PM
 * @License: (C) Copyright 2021, IceWould Co., Ltd.
 *
 * TODO: /oauth和自带/oauth重复，看看能不能复用
 */
@Api(tags = "认证模块")
@RestController
@RequestMapping("/oauth2")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    /**
     * Oauth2登录认证
     */
    @ApiOperation(value= "/token")
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public CommonResult<Oauth2TokenDto> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead("Bearer ").build();

        return CommonResult.success(oauth2TokenDto);
    }

    /**
     * 测试接口
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World.";
    }
}
