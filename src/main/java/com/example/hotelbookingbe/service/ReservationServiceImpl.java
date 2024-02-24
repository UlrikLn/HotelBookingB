package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Reservation;
import com.example.hotelbookingbe.model.Room;
import com.example.hotelbookingbe.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAllReservationsByRoom(Room room) {
        return reservationRepository.findAllByRoom(room);
    }



}
