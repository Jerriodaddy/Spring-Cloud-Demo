package com.icewould.oauth2auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Description:
 * @Author: Jerrio
 * @Date: 5/15/21 4:47 PM
 * @License: (C) Copyright 2021, IceWould Co., Ltd.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;
}
