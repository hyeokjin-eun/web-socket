package com.example.server.service;

import com.example.server.domain.Room;

import java.util.List;

public interface RoomService {

    Room createRoom();

    List<Room> getRoomList();

    boolean deleteRoom(String roomId);
}
