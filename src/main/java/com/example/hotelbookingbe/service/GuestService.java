package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Guest;

import java.util.List;

public interface GuestService {

    List<Guest> getAllGuests();

    Guest save(Guest guest);

    Guest findById(int guestId);

}
