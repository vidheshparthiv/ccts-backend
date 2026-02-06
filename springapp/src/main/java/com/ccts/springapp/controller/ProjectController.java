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
    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable int id){
        Optional<Project>c=ps.getProjectById(id);
        if(c.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c.get(),HttpStatus.OK);
    }
    @PutMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project Project){
        Project c=ps.addProject(Project);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Project> updateProject(@PathVariable int id,@RequestBody Project Project){
        Project c=ps.updateProject(id, Project);
        if(c==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable int id){
        Project c=ps.deleteProject(id);
        if(c==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAll(){
        ps.deleteAllProjects();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/sorted/{field}")
    public ResponseEntity<List<Project>> getAllSorted(@PathVariable String field){
        return new ResponseEntity<>(ps.getAllProjectsSorted(field),HttpStatus.OK);
    }
    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<Project>> getByPages(@PathVariable int page,@PathVariable int size){
        List<Project> c=ps.getByPages(page,size);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @GetMapping("/{page}/{size}/{field}")
    public ResponseEntity<List<Project>> getByPagesAndSorted(@PathVariable int page,@PathVariable int size,@PathVariable String field){
        List<Project> c=ps.getByPagesAndSorted(page,size,field);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
}
