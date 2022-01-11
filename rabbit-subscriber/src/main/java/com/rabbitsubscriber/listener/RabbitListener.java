package com.rabbitsubscriber.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitListener implements MessageListener {

    //initial method for when the message is received
    @Override
    public void onMessage(Message message) {
        System.out.println("message = " + new String(message.getBody()));
    }

}
