package com.springproyect.controllers;

import com.springproyect.apiService.IProjectService;
import com.springproyect.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/proyect")
public class ProjectController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/save")
    public void saveProject(@RequestBody Project project) {
        iProjectService.saveProject(project);

    }

    @GetMapping("/list")
    public List<Project> getProjects() {
        List<Project> projectList = iProjectService.getProjects();
        return projectList;
    }

    @GetMapping("/find/{id}")
    public Project findProject(@PathVariable Long id) {
        Project project = iProjectService.findProject(id);
        return project;
    }

    @PutMapping("/update/{id}")
    public void updateProject(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("description") String description
    ){

        //editar
        Project project = iProjectService.findProject(id);

        project.setName(name);
        project.setDescription(description);

        iProjectService.saveProject(project);

    }

}
