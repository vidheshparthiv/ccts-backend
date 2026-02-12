package com.ccts.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccts.springapp.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    @Query("select r from User r where r.role=?1")
    List<User> findByRole(String role);

    @Query("select r from User r where r.email=?1")
    Optional<User> findByEmail(String email);
}