package com.baokang.sdk.server;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author wahaha
 */
@Component
public class ActiveMQServer {

    @JmsListener(destination = com.baokang.sdk.config.Constants.TEST_TOPIC)
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);
    }
}