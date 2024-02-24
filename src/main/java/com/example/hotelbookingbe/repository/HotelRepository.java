package com.example.hotelbookingbe.repository;

import com.example.hotelbookingbe.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findAll();

    Hotel save(Hotel hotel);





}
