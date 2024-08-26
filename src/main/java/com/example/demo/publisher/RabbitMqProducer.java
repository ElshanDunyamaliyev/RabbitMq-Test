package com.example.demo.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMqProducer {

    @Value("${rabbitmq.exchange}")
    private String myExchange;

    @Value("${rabbitmq.routingKey}")
    private String myRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        log.info("Message sent to exchange -> {}",message);
        rabbitTemplate.convertAndSend(myExchange,myRoutingKey,message);
    }
}
