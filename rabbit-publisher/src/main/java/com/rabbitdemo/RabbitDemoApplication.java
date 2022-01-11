package com.rabbitdemo;

import com.rabbitdemo.objects.UserMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitDemoApplication implements CommandLineRunner {

    private static final String TEST_EXCHANGE = "test-exchange";
    private static final String TEST_ROUTING = "test-routing";
    private static final String MY_EXCHANGE = "my-topic-exchange";
    private static final String MY_BINDING = "my-routing-key";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitDemoApplication.class, args);
    }

    @Override
    public void run(String... strings){
        rabbitTemplate.convertAndSend("Default exchange");
        rabbitTemplate.convertAndSend(
                MY_EXCHANGE,
                MY_BINDING,
                "Hello, World!");
        rabbitTemplate.convertAndSend(
                TEST_EXCHANGE,
                TEST_ROUTING,
                new UserMessage("olavo", "pictures").toString());
    }

}
