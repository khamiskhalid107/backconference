package com.example.Visit.repository;

import com.example.Visit.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepo extends JpaRepository <Visitor , Integer> {
}
