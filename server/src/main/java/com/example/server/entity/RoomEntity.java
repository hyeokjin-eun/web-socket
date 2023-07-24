package com.example.server.entity;

import lombok.*;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {

    private String roomId;

    private Set<WebSocketSession> sessions = new HashSet<>();
}
