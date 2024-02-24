package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Reservation;
import com.example.hotelbookingbe.model.Room;

import java.util.List;

public interface ReservationService {
    Reservation save(Reservation reservation);

    List<Reservation> getAllReservations();

    void deleteReservation(int id);

    List<Reservation> getAllReservationsByRoom(Room room);

}
