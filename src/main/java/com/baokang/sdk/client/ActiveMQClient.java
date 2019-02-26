package com.baokang.sdk.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author wahaha
 */
@Component
public class ActiveMQClient {
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 生产消息
     *
     * @param destinationName
     * @param message
     */
    public void send(String destinationName, String message) {
        Assert.notNull(destinationName, "destinationName  is not null");
        jmsTemplate.convertAndSend(destinationName, message);
    }

}
