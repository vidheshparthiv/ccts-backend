package com.ccts.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccts.springapp.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {

}
