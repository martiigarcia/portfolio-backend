package com.springproyect.controllers;

import com.springproyect.apiService.IExtraExperience;
import com.springproyect.model.ExtraExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/experience")
public class ExtraExperienceController {

    @Autowired
    private IExtraExperience iExtraExperience;

    @PostMapping("/save")
    public Map<String, Object> saveExperience(@RequestBody ExtraExperience extraExperience) {
        Map<String, Object> map = new HashMap<>();
        try {
            iExtraExperience.saveExperience(extraExperience);
            map.put("result", "success");
            map.put("message", "El experiencia se guardo con exito");
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
            List<ExtraExperience> extraExperienceList = iExtraExperience.getExperience();
            map.put("experiences", extraExperienceList);
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

            ExtraExperience extraExperience = iExtraExperience.findExperience(id);
            if (extraExperience != null) {
                map.put("experience", extraExperience);
                map.put("result", "success");
                map.put("message", "La operacion se realizo con exito");
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

    @PutMapping("/update/{id}")
    public Map<String, Object> updateExperience(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description
    ) {
        //editar
        Map<String, Object> map = new HashMap<>();
        try {
            ExtraExperience extraExperience = iExtraExperience.findExperience(id);

            if (extraExperience != null) {
                extraExperience.setTitle(title);
                extraExperience.setDescription(description);

                iExtraExperience.saveExperience(extraExperience);
                map.put("result", "success");
                map.put("message", "La informacion de la experiencia del usuario se modifico con exito");

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
            List<ExtraExperience> extraExperienceList = iExtraExperience.getExperience();
            map.put("experiences", extraExperienceList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }


}
