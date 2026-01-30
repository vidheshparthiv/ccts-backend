package com.ccts.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private String content;

    private String author;

    
    public int getCommentId() {
        return commentId;
    }


    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public Comment(int commentId, String content, String author) {
        this.commentId = commentId;
        this.content = content;
        this.author = author;
    }


    public Comment() {
    }
    

}
