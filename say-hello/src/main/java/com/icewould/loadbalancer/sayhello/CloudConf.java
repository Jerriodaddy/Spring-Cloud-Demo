package com.icewould.loadbalancer.sayhello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Jerrio
 * @Date: 4/27/21 3:54 PM
 * @License: (C) Copyright 2021, IceWould Co., Ltd.
 */

@RefreshScope
@Configuration
public class CloudConf {

    @Value("${message:Hello default}")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
