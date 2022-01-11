package com.rabbitsubscriber.config;

import com.rabbitsubscriber.listener.RabbitListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//will handle all connections to broker
@Configuration
public class RabbitConfig {

    private static final String MY_Q = "my-queue";


    //1. Define the Queue to listen to
    @Bean
    Queue myQueue() {
        return new Queue(MY_Q, true);
    }

    @Bean
    Exchange myExchange(){
    return ExchangeBuilder
            .topicExchange("my-topic-exchange")
            .durable(true)
            .build();
    }

    @Bean
    Binding myBinding(){
        return BindingBuilder
                .bind(myQueue())
                .to(myExchange())
                .with("my-routing-key")
                .noargs();
    }

    //2. Provide the Connection to the Queue
    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    //3. Bind the Queue, Connection and Listener
    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitListener());
        return simpleMessageListenerContainer;
    }

}
