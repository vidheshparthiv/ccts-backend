package com.ccts.springapp.service;

import java.util.List;
import java.util.Optional;

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
}
