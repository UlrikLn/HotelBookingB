package com.example.hotelbookingbe.repository;

import com.example.hotelbookingbe.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findByHotelHotelId(int hotelId);

    Room save(Room room);

    // Qeurys til at finde det højeste roomNumber i et hotel. og returnere nul hvis ikke er nogle rum på det hotelId.
    @Query("SELECT COALESCE(MAX(r.roomNumber), 0) FROM Room r WHERE r.hotel.hotelId = :hotelId")
    int findMaxRoomNumberByHotel(@Param("hotelId") int hotelId);
}
