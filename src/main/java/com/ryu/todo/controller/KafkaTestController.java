package com.ryu.todo.controller;

import com.ryu.todo.kafka.KafkaConsumerService;
import com.ryu.todo.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaTestController {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaConsumerService kafkaConsumerService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaProducerService.sendMessage("todo-topic", message);
        return "Message sent to Kafka topic!";
    }

    @GetMapping("/consume")
    public List<String> consumeMessages(@RequestParam(defaultValue = "todo-topic") String topic) {
        return kafkaConsumerService.consumeMessages(topic);
    }
}
