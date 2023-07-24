package com.example.server.controller;

import com.example.server.domain.Room;
import com.example.server.model.RoomCreateResponse;
import com.example.server.model.RoomListResponse;
import com.example.server.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("")
    public ResponseEntity<RoomCreateResponse> createRoom() {
        Room room = roomService.createRoom();
        return ResponseEntity.ok(RoomCreateResponse.builder()
                .roomId(room.getRoomId())
                .build());
    }

    @GetMapping("")
    public ResponseEntity<List<RoomListResponse>> getRoomList() {
        List<Room> roomList = roomService.getRoomList();
        return ResponseEntity.ok(roomList.stream()
                .map(room -> RoomListResponse.builder()
                        .roomId(room.getRoomId())
                        .build())
                .collect(Collectors.toList()));
    }

    @DeleteMapping("{roomId}")
    public ResponseEntity<Boolean> deleteRoom(@PathVariable String roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.ok(true);
    }
}
