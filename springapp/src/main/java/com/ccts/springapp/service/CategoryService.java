package com.ccts.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    //get all by sorted value
    public List<Category> getAllCategoriesSorted(String field){//like name etc
        return cr.findAll(Sort.by(field));
    }

    //get by pages
    public List<Category> getByPages(int page,int size){
        Page<Category> c=cr.findAll(PageRequest.of(page, size));
        return c.getContent();
    }

    //get by pages and sorted
    public List<Category> getByPagesAndSorted(int page,int size,String field){
        Page<Category> c=cr.findAll(PageRequest.of(page,size,Sort.by(field)));
        return c.getContent();
    }

    //get by categoryName
    public Category getByName(String categoryName){
        Optional<Category>c=cr.findByName(categoryName);
        if(c.isEmpty()){
            return null;
        }
        return c.get();
    }

    //update category
    public Category updateCategory(int categoryId,Category category){
        Optional<Category> existingCategory=cr.findById(categoryId);
        if(existingCategory.isEmpty()){
            return null;
        }
        category.setCategoryId(categoryId);
        return cr.save(category);
    }

}