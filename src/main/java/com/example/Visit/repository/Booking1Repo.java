package com.example.Visit.repository;


import com.example.Visit.model.Booking1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Booking1Repo extends JpaRepository<Booking1 , Long> {
}
