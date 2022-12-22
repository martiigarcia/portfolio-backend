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
    public void addProject() {

    }

    @Override
    public Project findProject(Long id) {
        return null;
    }

    @Override
    public List<Project> getProjects() {
        return null;
    }


}
