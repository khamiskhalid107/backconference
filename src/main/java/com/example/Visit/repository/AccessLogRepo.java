package com.example.Visit.repository;

import com.example.Visit.model.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLogRepo extends JpaRepository<AccessLog,Integer> {
}
