package com.example.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private static final String CONNECT_WEBSOCKET = "/connect-websocket";
    private static final String ORIGIN_PATTERNS = "http://localhost:8080";
    private static final String BROKER_TOPIC_PREFIX = "/topic";
    private static final String APPLICATION_PREFIX = "/app";

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(CONNECT_WEBSOCKET)
                .setAllowedOriginPatterns(ORIGIN_PATTERNS)
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(BROKER_TOPIC_PREFIX);
        registry.setApplicationDestinationPrefixes(APPLICATION_PREFIX);
    }
}
