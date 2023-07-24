package com.example.server.service.impl;

import com.example.server.model.StompSender;
import com.example.server.service.StompMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StompMessageServiceImpl implements StompMessageService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void sendStompMessage(String topic, StompSender stompSender) {
        simpMessagingTemplate.convertAndSend(topic, stompSender);
    }
}
