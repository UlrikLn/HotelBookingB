package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    List<Hotel> getALlHotels();

    Hotel save(Hotel hotel);

    void deleteHotel(int id);

    Optional<Hotel> findById(int id);

}
