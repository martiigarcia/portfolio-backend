package com.springproyect.controllers;

import com.springproyect.apiService.IProjectService;
import com.springproyect.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/proyect")
public class ProjectController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/save")
    public Map<String, Object> saveProject(@RequestBody Project project) {
        Map<String, Object> map = new HashMap<>();
        try {
            iProjectService.saveProject(project);
            map.put("result", "success");
            map.put("message", "El proyecto se guardo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }

        return map;
    }

    @GetMapping("/list")
    public Map<String, Object> getProjects() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Project> projectList = iProjectService.getProjects();
            map.put("proyects", projectList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @GetMapping("/find/{id}")
    public Map<String, Object> findProject(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Project project = iProjectService.findProject(id);
            if (project != null) {
                map.put("proyect", project);
                map.put("result", "success");
                map.put("message", "La operacion se realizo con exito");
            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe el proyecto solicitado");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateProject(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("description") String description
    ) {
        Map<String, Object> map = new HashMap<>();
        try {
            //editar
            Project project = iProjectService.findProject(id);

            if (project != null) {
                project.setName(name);
                project.setDescription(description);

                iProjectService.saveProject(project);
                map.put("result", "success");
                map.put("message", "La informacion del proyecto se modifico con exito");

            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe el proyecto solicitado");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

}
