package com.springproyect.controllers;

import com.springproyect.apiService.IWorkExperienceService;
import com.springproyect.model.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/workExperience")
public class WorkExperienceController {

    @Autowired
    private IWorkExperienceService iWorkExperience;

    @PostMapping(path = "/save", consumes ="application/json")
    public Map<String, Object> saveExperience(@RequestBody WorkExperience workExperience) {
        System.out.println(workExperience);
        Map<String, Object> map = new HashMap<>();
        try {
            iWorkExperience.saveExperience(workExperience);
            map.put("result", "success");
            map.put("message", "El experiencia laboral se guardo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }

        return map;

    }

    @GetMapping("/list")
    public Map<String, Object> getExperiences() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<WorkExperience> workExperienceList = iWorkExperience.getExperiences();
            map.put("experiences", workExperienceList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @GetMapping("/find/{id}")
    public Map<String, Object> findExperience(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {

            WorkExperience workExperience = iWorkExperience.findExperience(id);
            if (workExperience != null) {
                map.put("experience", workExperience);
                map.put("result", "success");
                map.put("message", "La operacion se realizo con exito");
            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe la experiencia laboral solicitada");
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
            iWorkExperience.deleteWorkExperience(id);
            map.put("result", "success");
            map.put("message", "La experiencia laboral se elimino con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateExperience(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("period") String period,
            @RequestParam("place") String place
    ) {
        //editar
        Map<String, Object> map = new HashMap<>();
        try {
            WorkExperience workExperience = iWorkExperience.findExperience(id);

            if (workExperience != null) {
                workExperience.setTitle(title);
                workExperience.setDescription(description);
                workExperience.setPeriod(period);
                workExperience.setPlace(place);

                iWorkExperience.saveExperience(workExperience);
                map.put("result", "success");
                map.put("message", "La informacion de la experiencia laboral del usuario se modifico con exito");

            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe la experiencia solicitada");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @GetMapping("/byUser/{id}")
    public Map<String, Object> getExperiencesByUser(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<WorkExperience> workExperienceList = iWorkExperience.getExperienceByUser(id);
            map.put("experiences", workExperienceList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }


}
