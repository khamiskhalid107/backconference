package com.example.Visit.repository;

import com.example.Visit.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff,Integer> {
}
