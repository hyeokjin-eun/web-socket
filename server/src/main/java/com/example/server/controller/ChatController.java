package com.example.server.controller;

import com.example.server.domain.Chat;
import com.example.server.model.ChatSendRequest;
import com.example.server.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/chat/room/{roomId}/message")
    public void chatMessage(
            @PathVariable String roomId,
            ChatSendRequest chatSendRequest) {
        chatService.sendChat(roomId, Chat.builder()
                .message(chatSendRequest.getMessage())
                .build());
    }
}
