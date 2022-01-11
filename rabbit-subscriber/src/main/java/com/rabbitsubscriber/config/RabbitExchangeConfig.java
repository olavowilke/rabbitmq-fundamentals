package com.rabbitsubscriber.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitExchangeConfig {

    @Bean
    Exchange exampleExchange() {
        return new TopicExchange("example-exchange");
    }

    @Bean
    Exchange exampleExchange02() {
        return ExchangeBuilder
                .directExchange("example-exchange-02")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange topicExchangeExample(){
        return ExchangeBuilder
                .topicExchange("topic-exchange-example")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange fanoutExchange(){
        return ExchangeBuilder
                .fanoutExchange("fanout-exchange-example")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    Exchange headersExchange(){
        return ExchangeBuilder
                .headersExchange("headers-exchange-example")
                .durable(true)
                .ignoreDeclarationExceptions()
                .build();
    }

}
