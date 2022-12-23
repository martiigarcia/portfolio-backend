package com.springproyect.apiService;

import com.springproyect.model.Project;

import java.util.List;

public interface IProjectService {

    public void saveProject(Project project);

    public Project findProject(Long id);

    public List<Project> getProjects();

//    public List<Project> getProjectsByUser(Long id_user);
}
