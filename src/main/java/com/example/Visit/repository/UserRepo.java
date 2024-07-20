package com.example.Visit.repository;

import com.example.Visit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
//    @Query(value = "SELECT * FROM user WHERE username = :username",nativeQuery = true)
//    Optional<User>findByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);
}
