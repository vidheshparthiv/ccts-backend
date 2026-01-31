package com.ccts.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccts.springapp.model.Comment;
import com.ccts.springapp.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService cs;
    public CommentController(CommentService cs){
        this.cs=cs;
    }
    public ResponseEntity<List<Comment>> getAllComments(){
        List<Comment> comments=cs.getAllComments();
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }
    public ResponseEntity<Comment> getById(int id){
        Optional<Comment>c=cs.getCommentById(id);
        if(c.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c.get(),HttpStatus.OK);
    }
    public ResponseEntity<Comment> addComment(Comment comment){
        Comment c=cs.addComment(comment);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    public ResponseEntity<Comment> updateComment(int id,Comment comment){
        Comment c=cs.updateComment(id, comment);
        if(c==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
}
