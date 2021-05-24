package com.icewould.oauth2auth.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: Oauth2获取Token返回信息封装。
 * @Author: Jerrio
 * @Date: 5/15/21 4:47 PM
 * @License: (C) Copyright 2021, IceWould Co., Ltd.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Oauth2TokenDto {
    /**
     * 访问令牌
     */
    private String token;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 访问令牌头前缀
     */
    private String tokenHead;
    /**
     * 有效时间（秒）
     */
    private int expiresIn;
}
