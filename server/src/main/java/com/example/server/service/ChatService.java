package com.example.server.service;

import com.example.server.domain.Chat;

public interface ChatService {

    void sendChat(String roomId, Chat chat);
}
