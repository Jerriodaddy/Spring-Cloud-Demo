package com.icewould.sayhello.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:
 * @Author: Jerrio
 * @Date: 5/26/21 5:14 PM
 * @License: (C) Copyright 2021, IceWould Co., Ltd.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("say-hello APIs")
                        .description("# swagger-bootstrap-ui-demo RESTful APIs")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("Jerry",
                                "https://jerriodaddy.github.io/",
                                "jerrio20@outlook.com"))
                        .version("1.0")
                        .build())
                //分组名称
//                .groupName("v1.0.0")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.icewould.sayhello.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
