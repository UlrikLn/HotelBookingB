package com.example.hotelbookingbe.repository;

import com.example.hotelbookingbe.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

    List<Guest> findAll();

    Guest save(Guest guest);
}
