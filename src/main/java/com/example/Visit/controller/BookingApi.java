package com.example.Visit.controller;

import com.example.Visit.model.Booking;
import com.example.Visit.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Staff/Api")
@CrossOrigin(origins = "http://localhost:3000") // Replace with your React app's URL if different
public class BookingApi {

    @Autowired
    private BookingRepo bookingRepository;

    @PostMapping("/addBooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/allBookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return ResponseEntity.ok(bookings);
    }

    // Method to get the status of a booking by ID
    @GetMapping("/bookingStatus/{id}")
    public ResponseEntity<Object> getBookingStatus(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return ResponseEntity.ok(booking.getStatus());
    }

    // Method to update the status of a booking by ID
    @PutMapping("/updateBookingStatus/{id}")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Long id, @RequestBody String status) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(status);
        Booking updatedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(updatedBooking);
    }
}
