package com.ccts.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ccts.springapp.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    @Query("select c from Comment c order by c.author")
    List<Comment> findAllOrderByAuthor();
}
