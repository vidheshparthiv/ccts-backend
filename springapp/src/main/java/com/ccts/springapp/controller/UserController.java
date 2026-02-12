package com.ccts.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccts.springapp.model.User;
import com.ccts.springapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController (UserService userService){
        this.userService=userService;
    }

    @PostMapping // insertion of new entity
    public ResponseEntity<User> addUser(@RequestBody User user){
        User u = userService.addUser(user);
        return new ResponseEntity<>(u,HttpStatus.CREATED);
    }

    @GetMapping // get all user
    public ResponseEntity<List<User>> getAllUser(){
        List<User> u1 = userService.getAllUser();
        return new ResponseEntity<>(u1,HttpStatus.OK);
    }

    @PutMapping("/{id}") // update user entity
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
        User u = userService.updateUser(id,user);
        if(u==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @GetMapping("/{id}") // get by userId
    public ResponseEntity<User> getById(@PathVariable int id){
        Optional<User> u = userService.getById(id);
        if(u.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(u.get(),HttpStatus.OK);
    } 
    @GetMapping("/page/{path}/{size}") // pages
    public ResponseEntity<List<User>> getByPage(@PathVariable int path,@PathVariable int size){
        List<User> u=userService.paging(path, size);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @GetMapping("/page/{path}/{size}/{field}") // pages and sort
    public ResponseEntity<List<User>> getByPageAndSort(@PathVariable int path,@PathVariable int size,@PathVariable String field){
        List<User> u=userService.pagingAndSort(path, size,field);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @GetMapping("/sortBy/{field}") // sort
    public ResponseEntity<List<User>> sortBy(@PathVariable String field){
        List<User> u=userService.sort(field);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

     // GET - by email
     @GetMapping("/email/{stri}")
     public ResponseEntity<User> getByStatus(@PathVariable String stri){
        Optional<User> u =userService.getByEmail(stri);
        if(u.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(u.get(),HttpStatus.OK);
     }

     // GET - by role
    @GetMapping("/role/{str}")
    public ResponseEntity<List<User>> getByRole(@PathVariable String str){
        return new ResponseEntity<>(userService.getByRole(str),HttpStatus.OK);
    }

   
}