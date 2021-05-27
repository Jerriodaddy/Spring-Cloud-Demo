package com.icewould.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.icewould","org.n3r.idworker"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //排除自动加载数据源类
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
//        String httpUri = uriConfiguration.getHttpbin();
//
//        return builder.routes()
//                .route(p -> p
//                    .path("/get")
//                    .filters(f -> f.addRequestHeader("Hello", "World"))
//                    .uri(httpUri))
//                .build();
//    }
//
//    @ConfigurationProperties
//    class UriConfiguration {
//
//        private String httpbin = "http://httpbin.org:80";
//
//        public String getHttpbin() {
//            return httpbin;
//        }
//
//        public void setHttpbin(String httpbin) {
//            this.httpbin = httpbin;
//        }
//    }
}
