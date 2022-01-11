package com.rabbitsubscriber.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueConfig {

    @Bean
    Queue exampleQueue() {
        return new Queue("example-queue", false);
    }

    @Bean
    Queue exampleQueue02() {
        return QueueBuilder
                .durable("example-queue-02")
                .autoDelete()
                .exclusive()
                .build();
    }

}
