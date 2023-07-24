package com.example.server.repository;

import com.example.server.domain.Room;

import java.util.List;

public interface RoomRepository {

    Room save(Room room);

    List<Room> findAllRoom();

    void delete(Room room);

    Room findByRoomId(String roomId);
}
