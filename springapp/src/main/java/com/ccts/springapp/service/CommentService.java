package com.ccts.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    //delete by id
    public Comment deleteComment(int id){
        Optional<Comment>c=cr.findById(id);
        if(c.isEmpty()){
            return null;
        }
        cr.deleteById(id);
        return c.get();
    }

    //delete all
    public void deleteAllComments(){
        cr.deleteAll();
    }

    //get all by sorted value
    public List<Comment> getAllCommentsSorted(String field){//like name etc
        return cr.findAll(Sort.by(field));
    }

    //get by pages
    public List<Comment> getByPages(int page,int size){
        Page<Comment>c=cr.findAll(PageRequest.of(page, size));
        return c.getContent();
    }

    //get by pages and sorted
    public List<Comment> getByPagesAndSorted(int page,int size,String field){
        Page<Comment> c=cr.findAll(PageRequest.of(page,size,Sort.by(field)));
        return c.getContent();
    }

}
