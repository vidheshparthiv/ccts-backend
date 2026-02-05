package com.ccts.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccts.springapp.model.Project;
import com.ccts.springapp.service.ProjectService;

@RestController
public class ProjectController {
    public ProjectService ps;
    public ProjectController(ProjectService ps){
        this.ps=ps;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAll(){
        List<Project> projects=ps.getAll();
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable int id,@RequestBody Project project){
        Project p=ps.update(id, project);
        if(p==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}
