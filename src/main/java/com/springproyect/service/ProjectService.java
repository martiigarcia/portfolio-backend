package com.springproyect.service;

import com.springproyect.apiService.IProjectService;
import com.springproyect.model.Project;
import com.springproyect.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project findProject(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        return project;
    }

    @Override
    public List<Project> getProjects() {
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }


}
