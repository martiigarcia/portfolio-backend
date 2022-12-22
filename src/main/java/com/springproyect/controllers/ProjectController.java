package com.springproyect.controllers;

import com.springproyect.apiService.IProjectService;
import com.springproyect.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/proyect")
public class ProjectController {

    @Autowired
    private IProjectService iProjectService;

    @GetMapping("/list")
    public String getProjects() {
        return "GET ALL";
    }

    @GetMapping("/find/{id}")
    public String findProject(@PathVariable Long id) {
        return "FIND";
    }

    @GetMapping("/update/{id}")
    public void updateProject(
            @PathVariable Long id,
            @RequestParam("nombre") String name,
            @RequestParam("descripcion") String description,
            @RequestParam("fechaInicio") Date begging,
            @RequestParam("fechaFin") Date ending
    ) {
        //editar
    }

}
