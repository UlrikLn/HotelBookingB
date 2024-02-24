package com.example.hotelbookingbe.controller;

import com.example.hotelbookingbe.model.Guest;
import com.example.hotelbookingbe.model.Hotel;
import com.example.hotelbookingbe.model.Reservation;
import com.example.hotelbookingbe.model.Room;
import com.example.hotelbookingbe.service.GuestService;
import com.example.hotelbookingbe.service.HotelService;
import com.example.hotelbookingbe.service.ReservationService;
import com.example.hotelbookingbe.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class HotelRESTController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/allhotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getALlHotels();
    }

    @GetMapping("/hotelbyid/{id}")
    public Optional<Hotel> getHotelById(@PathVariable int id) {
        return hotelService.findById(id);
    }

    @GetMapping("/roomsbyhotelid/{id}")
    public List<Room> getAllRoomsByHotelId(@PathVariable int id) {
        return roomService.getAllRoomsByHotelId(id);
    }

    @PostMapping("/newhotel")
    public Hotel createOneHotel(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    @DeleteMapping("/deletehotel/{id}")
    public void deleteHotel(@PathVariable int id) {
        hotelService.deleteHotel(id);
    }

    //Her skulle jeg lige sætte roomCount automatisk
    @PutMapping("/updatehotel/{id}")
    public Hotel updateHotel(@PathVariable int id, @RequestBody Hotel hotelDetails) {
        Optional<Hotel> optionalHotel = hotelService.findById(id);

        if (optionalHotel.isPresent()) {
            Hotel existingHotel = optionalHotel.get();

            existingHotel.setName(hotelDetails.getName());
            existingHotel.setStreet(hotelDetails.getStreet());
            existingHotel.setCity(hotelDetails.getCity());
            existingHotel.setZip(hotelDetails.getZip());
            existingHotel.setCountry(hotelDetails.getCountry());
            existingHotel.setRoomCount(hotelDetails.getRoomCount());
            return hotelService.save(existingHotel);
        } else {
            return null;
        }
    }

    @PostMapping("/newroom")
    public Room createOneRoom(@RequestBody Room roomDetails) {
        Room room = new Room();
        room.setHotel(roomDetails.getHotel());
        room.setNumberOfBeds(roomDetails.getNumberOfBeds());
        return roomService.save(room);
    }

    @PutMapping("/updateroom/{id}")
    public Room updateRoom(@PathVariable int id, @RequestBody Room roomDetails) {
        Optional<Room> optionalRoom = roomService.getRoomById(id);

        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setRoomNumber(roomDetails.getRoomNumber());
            return roomService.save(existingRoom);
        } else {
            return null;
        }
    }

    @GetMapping("/allguests")
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @PostMapping("/newguest")
    public Guest createOneGuest(@RequestBody Guest guest) {
        return guestService.save(guest);
    }


    // Husk at jeg har glemt at have date med så den er ikke så præcis som jeg troede.
    @GetMapping("/allreservations/{hotelId}")
    public List<Reservation> getAllReservationsForHotel(@PathVariable int hotelId) {
        List<Room> rooms = roomService.getAllRoomsByHotelId(hotelId);
        List<Reservation> allReservations = new ArrayList<>();

        for (Room room : rooms) {
            allReservations.addAll(reservationService.getAllReservationsByRoom(room));
        }

        return allReservations;
    }
    @PostMapping("/newreservation/{guestId}/{roomId}/{date}")
    public Reservation createOneReservation(@PathVariable int guestId, @PathVariable int roomId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        Guest guest = guestService.findById(guestId);
        Room room = roomService.findById(roomId);

        Reservation reservation = new Reservation();

        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setReservationDate(date);

        return reservationService.save(reservation);
    }

    @DeleteMapping("/deletereservation/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }







}
