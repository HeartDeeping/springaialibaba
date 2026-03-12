package com.springAiAlibaba.controller;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatHelloController {
    @Autowired
    private ChatModel chatModel;

    @GetMapping("/qwen/doChat")
    public String doChat(@RequestParam(value = "question",defaultValue = "你是谁") String question) {
        return chatModel.call(question);
    }

    @GetMapping("/qwen/streamChat")
    public Flux<String> streamChat(@RequestParam(value = "question",defaultValue = "你是谁") String question) {
        return chatModel.stream(question);
    }
}
