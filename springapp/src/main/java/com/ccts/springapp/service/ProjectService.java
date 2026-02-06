package com.ccts.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ccts.springapp.model.Project;
import com.ccts.springapp.repository.ProjectRepo;

@Service
public class ProjectService {
    public ProjectRepo pr;
    private  ProjectService(ProjectRepo pr){
        this.pr=pr;
    }
    // get all
    public List<Project> getAll(){
        return pr.findAll();
    }
    //update
    public Project update(int id,Project project){
        Optional<Project>p=pr.findById(id);
        if(p.isEmpty()){
            return null;
        }
        project.setProjectId(id);
        return pr.save(project);
    }

    //get by id
    public Optional<Project> getProjectById(int id){
        return pr.findById(id);
    }

    //add Project
    public Project addProject(Project Project){
        return pr.save(Project);
    }

    //update Project
    public Project updateProject(int id,Project Project){
        Optional <Project>c=pr.findById(id);
        if(c.isEmpty()){
            return null;
        }
        Project.setProjectId(id);
        return pr.save(Project);
    }

    //delete by id
    public Project deleteProject(int id){
        Optional<Project>c=pr.findById(id);
        if(c.isEmpty()){
            return null;
        }
        pr.deleteById(id);
        return c.get();
    }

    //delete all
    public void deleteAllProjects(){
        pr.deleteAll();
    }

    //get all by sorted value
    public List<Project> getAllProjectsSorted(String field){//like name etc
        return pr.findAll(org.springframework.data.domain.Sort.by(field));
    }

    //get by pages
    public List<Project> getByPages(int page,int size){
        Page<Project>c=pr.findAll(PageRequest.of(page, size));
        return c.getContent();
    }

    //get by pages and sorted
    public List<Project> getByPagesAndSorted(int page,int size,String field){
        Page<Project> c=pr.findAll(PageRequest.of(page,size,org.springframework.data.domain.Sort.by(field)));
        return c.getContent();
    }

}
