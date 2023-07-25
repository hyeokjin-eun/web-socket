package com.example.server.controller;

import com.example.server.domain.Chat;
import com.example.server.model.ChatSendRequest;
import com.example.server.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/chat/room/message")
    public void chatMessage(
            ChatSendRequest chatSendRequest) {
        chatService.sendChat(chatSendRequest.getRoomId(), Chat.builder()
                .message(chatSendRequest.getMessage())
                .build());
    }
}
