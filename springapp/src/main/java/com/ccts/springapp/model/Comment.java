package com.ccts.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    private String content;

    private String author;

    
    public long getCommentId() {
        return commentId;
    }


    public void setCommentId(long commentId) {
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


    public Comment(long commentId, String content, String author) {
        this.commentId = commentId;
        this.content = content;
        this.author = author;
    }


    public Comment() {
    }
    

}
