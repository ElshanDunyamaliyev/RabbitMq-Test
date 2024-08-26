package com.example.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMqConsumer {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consumeMessage(String message){
        log.info("Message came to queue -> {}",message);
    }
}
