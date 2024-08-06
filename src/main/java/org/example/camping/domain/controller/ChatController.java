package org.example.camping.domain.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatController {

    private final OpenAiChatModel chatModel;

    @Autowired
    public ChatController(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        String response = "나는 지금 캠핑장 소개 웹페이지를 만들고 있어. 사용자에게 정보를 제공해야하기 때문에, 존댓말로 공손하고 필요한 정보만 보이게 요약해서 문장을 패러프레이징 해줘" + message;
        return Map.of("generation", chatModel.call(response));
    }
}