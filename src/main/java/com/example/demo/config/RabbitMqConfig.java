package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.queue}")
    private String myQueue;

    @Value("${rabbitmq.exchange}")
    private String myExchange;

    @Value("${rabbitmq.routingKey}")
    private String myRoutingKey;

    @Bean
    public Queue queue(){
        return new Queue(myQueue);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(myExchange);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(myRoutingKey);
    }
}
