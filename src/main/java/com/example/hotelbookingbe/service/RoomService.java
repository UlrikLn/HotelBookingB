package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> getAllRoomsByHotelId(int id);

    Optional<Room> getRoomById(int id);

    Room save(Room room);

    Room findById(int roomId);

}
