package com.shy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration//开启dubbo配置
 public class DubboSsmConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSsmConsumerApplication.class, args);
    }
}
