package com.springproyect.controllers;

import com.springproyect.apiService.IAcademicExperienceService;
import com.springproyect.model.AcademicExperience;
import com.springproyect.model.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/workExperience")
public class AcademicExperienceController {

    @Autowired
    private IAcademicExperienceService iAcademicExperience;

    @PostMapping("/save")
    public Map<String, Object> saveExperience(@RequestBody AcademicExperience academicExperience) {
        Map<String, Object> map = new HashMap<>();
        try {
            iAcademicExperience.saveExperience(academicExperience);
            map.put("result", "success");
            map.put("message", "El experiencia academica se guardo con exito");
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
            List<AcademicExperience> academicExperienceList = iAcademicExperience.getExperiences();
            map.put("experiences", academicExperienceList);
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

            AcademicExperience academicExperience = iAcademicExperience.findExperience(id);
            if (academicExperience != null) {
                map.put("experience", academicExperience);
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
            iAcademicExperience.deleteAcademicExperience(id);
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
            @RequestParam("period") String period,
            @RequestParam("place") String place
    ) {
        //editar
        Map<String, Object> map = new HashMap<>();
        try {
            AcademicExperience academicExperience = iAcademicExperience.findExperience(id);

            if (academicExperience != null) {
                academicExperience.setTitle(title);
                academicExperience.setPeriod(period);
                academicExperience.setPlace(place);

                iAcademicExperience.saveExperience(academicExperience);
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
            List<AcademicExperience> academicExperienceList = iAcademicExperience.getExperienceByUser(id);
            map.put("experiences", academicExperienceList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }


}
