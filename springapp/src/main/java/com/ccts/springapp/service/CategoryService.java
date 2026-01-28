package com.ccts.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccts.springapp.model.Category;
import com.ccts.springapp.repository.CategoryRepo;

@Service
public class CategoryService {
    private CategoryRepo cr;
    public CategoryService (CategoryRepo cr){
        this.cr=cr;
    }
    
    //add category
    public Category addCategory(Category category){
        return cr.save(category);
    }
    
    //get category by id
    public Category getcategorybyid(int id){
        Optional<Category> s= cr.findById(id);
        if(s.isEmpty()){
            return null;
        }
        return s.get();
    }

    //get all categories
    public List<Category> getAllCtargory(){
        return cr.findAll();
    }

    //delete all
    public void deleteAllCategories(){
        cr.deleteAll();
    }

    //delete by id
    public boolean deleteCategoryById(int id){
        Optional<Category> c=cr.findById(id);
        if(c.isEmpty()){
            return false;
        }
        cr.deleteById(id);
        return true;
    }
}