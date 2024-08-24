package com.example.Visit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Booking1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


        private Long bookingId;

        private Long staffId;

        private Long visitorId;

        private LocalDate date;

//        private LocalTime time;

        private String notes;

        private String status;

        private String service;

        // Getters and Setters

        public Long getBookingId() {
            return bookingId;
        }

        public void setBookingId(Long bookingId) {
            this.bookingId = bookingId;
        }

        public Long getStaffId() {
            return staffId;
        }

        public void setStaffId(Long staffId) {
            this.staffId = staffId;
        }

        public Long getVisitorId() {
            return visitorId;
        }

        public void setVisitorId(Long visitorId) {
            this.visitorId = visitorId;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

//        public LocalTime getTime() {
//            return time;
//        }
//
//        public void setTime(LocalTime time) {
//            this.time = time;
//        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }
    }


