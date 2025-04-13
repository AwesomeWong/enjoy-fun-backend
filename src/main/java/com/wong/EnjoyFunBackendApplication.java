package com.wong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.server.ServletServerHttpRequest;

@MapperScan("com.wong.mapper")
//@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class EnjoyFunBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(EnjoyFunBackendApplication.class, args);
    }

}
