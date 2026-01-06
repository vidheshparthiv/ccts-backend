package com.ccts.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccts.springapp.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

}
