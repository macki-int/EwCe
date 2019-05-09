package pl.mj.EwCe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mj.EwCe.model.Project;
import pl.mj.EwCe.repository.ProjectRepository;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    public List<Project> get( ){
        return projectRepository.findAll();
    }
}
