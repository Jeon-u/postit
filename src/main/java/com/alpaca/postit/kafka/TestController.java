package com.alpaca.postit.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/kafka/test")
public class TestController {
    private final Producers producers;

    @Autowired
    TestController(Producers producers) {
        this.producers = producers;
    }

    @PostMapping("/message")
    public String sendMessage(@RequestParam("message") String message) {
        this.producers.sendMessage(message);
        return "success";
    }
}
