package com.example.hotelbookingbe.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.hotelbookingbe.model.Hotel;
import com.example.hotelbookingbe.repository.HotelRepository;
import com.example.hotelbookingbe.service.HotelService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

@SpringBootTest
public class HotelServiceImplTest {

    @Autowired
    private HotelRepository hotelRepository;

    @MockBean
    private HotelService hotelService;

    @Test
    public void testGetAllHotels() {
        // Arrange
        Hotel hotel1 = new Hotel(1, "Hotel A");
        Hotel hotel2 = new Hotel(2, "Hotel B");
        hotelRepository.save(hotel1);
        hotelRepository.save(hotel2);
        when(hotelService.getALlHotels()).thenReturn(Arrays.asList(hotel1, hotel2));

        // Act
        Iterable<Hotel> hotels = hotelService.getALlHotels();

        // Assert
        assertEquals(2, hotels.spliterator().getExactSizeIfKnown());
    }



}
