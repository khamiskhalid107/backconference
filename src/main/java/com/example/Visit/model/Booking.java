package com.example.Visit.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BookingId;

    @ManyToOne
    @JoinColumn(name = "id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "S_id")
    private Service service;

    private String status;


    private LocalDate date;

}
