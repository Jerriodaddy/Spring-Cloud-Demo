package com.icewould.sayhello.controller;

import com.icewould.sayhello.config.CloudConf;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: Jerrio
 * @Date: 4/26/21 10:11 PM
 * @License: (C) Copyright 2021, IceWould Co., Ltd.
 */

@RestController
public class HelloController {
    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private CloudConf cloudConf;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/message")
    String getMessage() {
        return cloudConf.getMessage();
    }
}
