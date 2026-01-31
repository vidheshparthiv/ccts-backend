package com.ccts.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ccts.springapp.model.Comment;
import com.ccts.springapp.repository.CommentRepo;

@Service
public class CommentService {
    public CommentRepo cr;
    public CommentService(CommentRepo cr){
        this.cr=cr;
    }

    //get all
    public List<Comment> getAllComments(){
        return cr.findAll();
    }

    //get by id
    public Optional<Comment> getCommentById(int id){
        return cr.findById(id);
    }

    //add comment
    public Comment addComment(Comment comment){
        return cr.save(comment);
    }

    //update comment
    public Comment updateComment(int id,Comment comment){
        Optional <Comment>c=cr.findById(id);
        if(c.isEmpty()){
            return null;
        }
        comment.setCommentId(id);
        return cr.save(comment);
    }
    
}
