package com.example.Visit.controller;

import com.example.Visit.model.Booking1;
import com.example.Visit.repository.Booking1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/Booking1/")
@CrossOrigin(origins = "http://localhost:3000")
public class Booking1API {
    @Autowired
    private Booking1Repo booking1Repo;

    @PostMapping("/addBooking1")
    public ResponseEntity<Booking1> addBooking(@RequestBody Booking1 booking) {
        Booking1 savedBooking = booking1Repo.save(booking);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/allBooking1")
    public ResponseEntity<List<Booking1>> getAllBookings() {
        List<Booking1> bookings = booking1Repo.findAll();
        return ResponseEntity.ok(bookings);
    }

    // Method to get the status of a booking by ID
    @GetMapping("/bookingStatus/{id}")
    public ResponseEntity<Object> getBookingStatus(@PathVariable Long id) {
        Booking1 booking = booking1Repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return ResponseEntity.ok(booking.getStatus());
    }

    // Method to update the status of a booking by ID
    @PutMapping("/updateBookingStatus/{id}")
    public ResponseEntity<Booking1> updateBookingStatus(@PathVariable Long id, @RequestBody String status) {
        Booking1 booking1 = booking1Repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking1.setStatus(status);
        Booking1 updatedBooking = booking1Repo.save(booking1);
        return ResponseEntity.ok(updatedBooking);
    }

    @GetMapping("/booking1Count")
    public ResponseEntity<Long> getBookingCount() {
        long count = booking1Repo.count();
        return ResponseEntity.ok(count);
    }

    // Method to delete a booking by ID
    @DeleteMapping("/deleteBooking1/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        Booking1 booking = booking1Repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking1Repo.delete(booking);
        return ResponseEntity.noContent().build();
    }


}
