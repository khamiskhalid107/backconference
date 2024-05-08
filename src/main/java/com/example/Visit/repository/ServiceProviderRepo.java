package com.example.Visit.repository;

import com.example.Visit.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepo extends JpaRepository<ServiceProvider,Integer> {
}
