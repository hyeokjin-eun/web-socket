package com.example.server.service.impl;

import com.example.server.domain.Room;
import com.example.server.repository.RoomRepository;
import com.example.server.service.RoomService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Room createRoom() {
        String roomId = UUID.randomUUID().toString();
        Room room = Room.builder()
                .roomId(roomId)
                .build();

        return roomRepository.save(room);
    }

    @Override
    public List<Room> getRoomList() {
        return roomRepository.findAllRoom();
    }

    @Override
    public void deleteRoom(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        roomRepository.delete(room);
    }
}
