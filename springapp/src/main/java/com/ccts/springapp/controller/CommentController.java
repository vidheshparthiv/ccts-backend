package com.ccts.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments(){
        List<Comment> comments=cs.getAllComments();
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getById(@PathVariable int id){
        Optional<Comment>c=cs.getCommentById(id);
        if(c.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c.get(),HttpStatus.OK);
    }
    @PutMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        Comment c=cs.addComment(comment);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Comment> updateComment(@PathVariable int id,@RequestBody Comment comment){
        Comment c=cs.updateComment(id, comment);
        if(c==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable int id){
        Comment c=cs.deleteComment(id);
        if(c==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAll(){
        cs.deleteAllComments();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/sorted/{field}")
    public ResponseEntity<List<Comment>> getAllSorted(@PathVariable String field){
        return new ResponseEntity<>(cs.getAllCommentsSorted(field),HttpStatus.OK);
    }
    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<Comment>> getByPages(@PathVariable int page,@PathVariable int size){
        List<Comment> c=cs.getByPages(page,size);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @GetMapping("/{page}/{size}/{field}")
    public ResponseEntity<List<Comment>> getByPagesAndSorted(@PathVariable int page,@PathVariable int size,@PathVariable String field){
        List<Comment> c=cs.getByPagesAndSorted(page,size,field);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
}
