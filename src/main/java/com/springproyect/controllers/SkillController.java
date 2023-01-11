package com.springproyect.controllers;

import com.springproyect.apiService.ISkillService;
import com.springproyect.model.Proyect;
import com.springproyect.model.Skill;
import com.springproyect.model.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private ISkillService iSkillService;

    @PostMapping("/save")
    public Map<String, Object> saveSkill(@RequestBody Skill skill) {
        Map<String, Object> map = new HashMap<>();
        try {
            iSkillService.saveSkill(skill);
            map.put("result", "success");
            map.put("message", "La habilidad se guardo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }

        return map;
    }

    @GetMapping("/list")
    public Map<String, Object> getSkill() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Skill> skillList = iSkillService.getSkill();
            map.put("proyects", skillList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @GetMapping("/find/{id}")
    public Map<String, Object> findSkill(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Skill skill = iSkillService.findSkill(id);
            if (skill != null) {
                map.put("proyect", skill);
                map.put("result", "success");
                map.put("message", "La operacion se realizo con exito");
            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe la habilidad solicitado");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteSkill(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            iSkillService.deleteSkill(id);
            map.put("result", "success");
            map.put("message", "La habilidad se elimino con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateSkill(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("percentage") String percentage
            ) {
        Map<String, Object> map = new HashMap<>();
        try {
            //editar
            Skill skill = iSkillService.findSkill(id);

            if (skill != null) {
                skill.setTitle(name);
                skill.setPercentage(percentage);

                iSkillService.saveSkill(skill);
                map.put("result", "success");
                map.put("message", "La informacion la habilidad se modifico con exito");

            } else {
                map.put("result", "error");
                map.put("message", "Algo salio mal... No existe la habilidad solicitado");
            }
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }

    @GetMapping("/byUser/{id}")
    public Map<String, Object> getSkillsByUser(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Skill> skillList = iSkillService.getSkillsByUser(id);
            map.put("skills", skillList);
            map.put("result", "success");
            map.put("message", "La operacion se realizo con exito");
        } catch (Exception e) {
            map.put("result", "error");
            map.put("message", "Algo salio mal... " + e.getMessage());
        }
        return map;
    }
}
