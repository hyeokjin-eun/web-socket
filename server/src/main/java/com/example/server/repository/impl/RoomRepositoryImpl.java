package com.example.server.repository.impl;

import com.example.server.domain.Room;
import com.example.server.repository.RoomRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    private Map<String, Room> rooms;

    @PostConstruct
    private void init() {
        rooms = new LinkedHashMap<>();
    }

    @Override
    public Room save(Room room) {
        rooms.put(room.getRoomId(), room);
        return room;
    }

    @Override
    public List<Room> findAllRoom() {
        return new ArrayList<>(rooms.values());
    }

    @Override
    public void delete(Room room) {
        rooms.remove(room.getRoomId());
    }

    @Override
    public Room findByRoomId(String roomId) {
        if (rooms == null || rooms.isEmpty()) {
            return null;
        }

        return rooms.get(roomId);
    }
}
