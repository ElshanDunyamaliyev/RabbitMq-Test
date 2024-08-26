package com.example.demo.controller;

import com.example.demo.publisher.RabbitMqProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMqProducer rabbitMqProducer;

    @GetMapping
    public String sendMessage(@RequestParam("message") String message){
        rabbitMqProducer.sendMessage(message);
        return "Message sent to rabbitMq successfully";
    }
}
