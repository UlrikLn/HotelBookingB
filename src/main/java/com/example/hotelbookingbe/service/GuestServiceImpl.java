package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Guest;
import com.example.hotelbookingbe.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest findById(int guestId) {
        return guestRepository.findById(guestId).get();
    }
}

