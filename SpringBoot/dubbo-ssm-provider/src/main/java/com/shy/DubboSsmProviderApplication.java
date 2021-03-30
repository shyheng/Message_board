package com.shy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.shy.mapper")
@EnableDubboConfiguration //开启dubbo配置
public class DubboSsmProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSsmProviderApplication.class, args);
    }

}
