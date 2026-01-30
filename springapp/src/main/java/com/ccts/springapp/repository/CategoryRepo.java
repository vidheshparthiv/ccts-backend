package com.ccts.springapp.repository;
import com.ccts.springapp.model.Category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Query("select r from Category r where r.categoryName=?1")
    Optional<Category> findByName(String categoryName);

}
