package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Room;
import com.example.hotelbookingbe.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRoomsByHotelId(int id) {
        return roomRepository.findByHotelHotelId(id);
    }

    @Override
    public Optional<Room> getRoomById(int id) {
        return roomRepository.findById(id);
    }

    // Den her sørger for at hvert rum som bliver lavet til det hotel, får et rigtigt nummer som tilsvarer det hotel.
    @Override
    public Room save(Room room) {
        if (room.getHotel() != null && room.getRoomNumber() == 0) {
            int maxRoomNumber = roomRepository.findMaxRoomNumberByHotel(room.getHotel().getHotelId());
            room.setRoomNumber(maxRoomNumber + 1);
        }
        return roomRepository.save(room);
    }

    @Override
    public Room findById(int roomId) {
        return roomRepository.findById(roomId).get();
    }

}
