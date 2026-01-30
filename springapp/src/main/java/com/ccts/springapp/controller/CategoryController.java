package com.ccts.springapp.controller;

import com.ccts.springapp.model.Category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Category> addCategory(@RequestBody Category cat){
        return new ResponseEntity<>(cs.addCategory(cat),HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<>(cs.getAllCtargory(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id){
        Category c=cs.getcategorybyid(id);
        if(c==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        boolean deleted=cs.deleteCategoryById(id);
        if(!deleted){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAll(){
        cs.deleteAllCategories();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/sorted/{field}")
    public ResponseEntity<List<Category>> getAllSorted(@PathVariable String field){
        return new ResponseEntity<>(cs.getAllCategoriesSorted(field),HttpStatus.OK);
    }
    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<Category>> getByPages(@PathVariable int page,@PathVariable int size){
        List<Category> c=cs.getByPages(page,size);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @GetMapping("/{page}/{size}/{field}")
    public ResponseEntity<List<Category>> getByPagesAndSorted(@PathVariable int page,@PathVariable int size,@PathVariable String field){
        List<Category> c=cs.getByPagesAndSorted(page,size,field);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Category> getByName(@PathVariable String name){
        Category c=cs.getByName(name);
        if(c==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK); 
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id,@RequestBody Category category){
        Category c=cs.updateCategory(id,category);
        if(c==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
}