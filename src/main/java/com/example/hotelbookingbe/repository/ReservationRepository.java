package com.example.hotelbookingbe.repository;

import com.example.hotelbookingbe.model.Reservation;
import com.example.hotelbookingbe.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Reservation save(Reservation reservation);


    List<Reservation> findAllByRoom(Room room);
}
