package com.ccts.springapp.controller;

import com.ccts.springapp.model.Category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccts.springapp.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService cs;
    private CategoryController(CategoryService cs){
        this.cs=cs;
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(Category cat){
        return new ResponseEntity<>(cs.addCategory(cat),HttpStatus.OK);
    }

    

}
