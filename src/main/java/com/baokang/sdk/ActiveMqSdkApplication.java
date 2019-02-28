package com.baokang.sdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wahaha
 */
@SpringBootApplication
@EnableJms
@ComponentScan(basePackages = {"com.baokang"})
public class ActiveMqSdkApplication {

    /**
     * 启动入口
     *
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(ActiveMqSdkApplication.class, args);
    }

}
