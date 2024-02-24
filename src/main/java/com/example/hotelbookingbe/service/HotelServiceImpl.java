package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Hotel;
import com.example.hotelbookingbe.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository HotelRepository;

    @Override
    public List<Hotel> getALlHotels() {
        return HotelRepository.findAll();
    }

    @Override
    public Hotel save(Hotel hotel) {
        return HotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(int id) {
        HotelRepository.deleteById(id);
    }

    @Override
    public Optional<Hotel> findById(int id) {
        return HotelRepository.findById(id);
    }


}
