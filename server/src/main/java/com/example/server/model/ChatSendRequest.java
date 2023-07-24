package com.example.server.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatSendRequest {

    private String message;
}
