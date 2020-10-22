package com.phenoxp.kafka.controller;

import com.phenoxp.kafka.configuration.MyTopicConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaTemplate<String, String> template;
    private final MyTopicConsumer topicConsumer;

    public KafkaController(KafkaTemplate<String, String> template, MyTopicConsumer topicConsumer) {
        this.template = template;
        this.topicConsumer = topicConsumer;
    }

    @PostMapping("/produce")
    public void produce(@RequestBody String message) {
        template.send("myTopic", message);
    }

    @GetMapping("/messages")
    public List<String> getMessages(){
        return topicConsumer.getMessages();
    }

}
