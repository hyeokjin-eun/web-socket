package com.example.server.service.impl;

import com.example.server.domain.Chat;
import com.example.server.model.StompSender;
import com.example.server.service.ChatService;
import com.example.server.service.StompMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final StompMessageService stompMessageService;

    private static final String SUB_ROOM_TOPIC_PREFIX = "/topic/chat/room";

    @Override
    public void sendChat(String roomId, Chat chat) {
        stompMessageService.sendStompMessage(SUB_ROOM_TOPIC_PREFIX + roomId, StompSender.builder()
                .message(chat.getMessage())
                .build());
    }
}
