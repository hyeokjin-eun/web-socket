package com.example.server.service;

import com.example.server.model.StompSender;

public interface StompMessageService {

    void sendStompMessage(String topic, StompSender stompSender);
}
