package com.ccts.springapp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ccts.springapp.model.User;
import com.ccts.springapp.repository.UserRepo;

@Service
public class UserService {
    private final UserRepo uRep;
    public UserService (UserRepo uRep){
        this.uRep=uRep;
    }

    // insert in to entity - POST
    public User addUser(User user){
        return uRep.save(user);
    }

    // select * from user - GET
    public List<User> getAllUser(){
        return uRep.findAll();
    }

    // select by id - GET
    public Optional<User> getById(int id){
        return uRep.findById(id);
    }
    
    // update user - PUT
    public User updateUser(int id,User user){
        Optional<User> s = uRep.findById(id);
        if(s.isEmpty()){
            return null;
        } 
        user.setUserId(id);
        return uRep.save(user);
    }
    // get by pages
    public List<User> paging(int page,int size){
        Page<User>s= uRep.findAll(PageRequest.of(page, size));
        return s.getContent();
        
    }

    //get by sorted values
    public List<User> sort(String field){
        return uRep.findAll(Sort.by(field));
    }

    // get by page and sorted values
    public List<User> pagingAndSort(int page,int size,String field){
        Page<User> s= uRep.findAll(PageRequest.of(page, size,Sort.by(field)));
        return s.getContent();
    }

    // GET - by Role
    public List<User> getByRole(String str){
        List<User> u = uRep.findByRole(str);
        if(u.isEmpty()){
            return null;
        }
        return u;
    }

    // GET - by email
    public Optional<User> getByEmail(String str){
        return uRep.findByEmail(str);
        
    }
}