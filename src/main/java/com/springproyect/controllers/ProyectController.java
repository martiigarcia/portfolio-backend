package com.springproyect.controllers;

import com.springproyect.apiService.IProyectService;
import com.springproyect.model.Proyect;
import com.springproyect.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/proyect")
public class ProyectController {

    @Autowired
    private IProyectService iProyectService;

    @PostMapping("/save")
    public Map<String, Object> saveProyect(@RequestBody Proyect proyect) {
        Map<String, Object> map = new HashMap<>();
        try {
            iProyectService.saveProyect(proyect);
            map.put("result", "success");
            map.put("message", "El proyecto se guardo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }

        return map;
    }

    @GetMapping("/list")
    public Map<String, Object> getProyects() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Proyect> proyectList = iProyectService.getProyects();
            map.put("proyects", proyectList);
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
            Proyect proyect = iProyectService.findProyect(id);
            if (proyect != null) {
                map.put("proyect", proyect);
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

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteUser(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            iProyectService.deleteProyect(id);
            map.put("result", "success");
            map.put("message", "El proyecto se elimino con exito");
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
            @RequestParam("description") String description,
            @RequestParam("period") String period
    ) {
        Map<String, Object> map = new HashMap<>();
        try {
            //editar
            Proyect proyect = iProyectService.findProyect(id);

            if (proyect != null) {
                proyect.setName(name);
                proyect.setDescription(description);
                proyect.setPeriod(period);

                iProyectService.saveProyect(proyect);
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
    @GetMapping("/byUser/{id}")
    public Map<String, Object> getProyectsByUser(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Proyect> proyectList = iProyectService.getProyectsByUser(id);
            map.put("proyects", proyectList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }
}
