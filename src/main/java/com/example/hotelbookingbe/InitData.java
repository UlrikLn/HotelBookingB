package com.example.hotelbookingbe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.hotelbookingbe.model.Hotel;
import com.example.hotelbookingbe.model.Room;
import com.example.hotelbookingbe.repository.HotelRepository;
import com.example.hotelbookingbe.repository.RoomRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Hotel> hotels = generateDummyHotels(250);
        hotelRepository.saveAll(hotels);
        hotels.forEach(hotel -> generateAndSaveRoomsForHotel(hotel, 15));
    }

    private List<Hotel> generateDummyHotels(int hotelCount) {
        List<Hotel> hotels = new ArrayList<>();
        for (int i = 1; i <= hotelCount; i++) {
            Hotel hotel = new Hotel();
            hotel.setName(String.format("hotel%03d", i));
            hotel.setStreet("Sample Street");
            hotel.setCity("Sample City");
            hotel.setZip(12345);
            hotel.setCountry("Sample Country");
            hotel.setCreated(LocalDateTime.now());
            hotel.setUpdated(LocalDateTime.now());
            hotel.setRoomCount(20);
            hotels.add(hotel);
        }
        return hotels;
    }

    private void generateAndSaveRoomsForHotel(Hotel hotel, int roomCount) {
        Random random = new Random();
        List<Room> rooms = new ArrayList<>();
        for (int i = 1; i <= roomCount; i++) {
            Room room = new Room();
            room.setRoomNumber(i);
            room.setNumberOfBeds(1 + random.nextInt(4)); // Random number of beds between 1 and 4
            room.setCreated(LocalDateTime.now());
            room.setUpdated(LocalDateTime.now());
            room.setHotel(hotel);
            rooms.add(room);
        }
        roomRepository.saveAll(rooms); // Save rooms to the database
    }
}
