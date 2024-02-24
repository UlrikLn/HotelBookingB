package com.example.hotelbookingbe.service;

import com.example.hotelbookingbe.model.Guest;
import com.example.hotelbookingbe.repository.GuestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GuestServiceImplTest {

    @MockBean
    private GuestRepository guestRepository;

    @Autowired
    private GuestService guestService;

    @Test
    public void testSaveGuest() {
        // Arrange
        Guest guestToSave = new Guest();
        when(guestRepository.save(any(Guest.class))).thenReturn(guestToSave);

        // Act
        Guest savedGuest = guestService.save(guestToSave);

        // Assert
        assertNotNull(savedGuest, "Saved guest should not be null");
        verify(guestRepository, times(1)).save(guestToSave);
    }
}
