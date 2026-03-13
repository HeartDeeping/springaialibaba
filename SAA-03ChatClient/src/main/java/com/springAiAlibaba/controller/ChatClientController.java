package com.springAiAlibaba.controller;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatClientController {
//    private final ChatClient chatClient;
//
//    public ChatClientController(DashScopeChatModel chatModel) {
//        this.chatClient = ChatClient.builder(chatModel).build();
//    }

    @Autowired
    private ChatClient chatClient;

    @GetMapping("/chatClient/doChat")
    public String doChat(@RequestParam(value = "question", defaultValue = "你是谁？") String question) {
        return chatClient.prompt().user(question).call().content();
    }
}
