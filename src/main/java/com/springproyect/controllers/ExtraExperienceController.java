package com.springproyect.controllers;

import com.springproyect.apiService.IExtraExperience;
import com.springproyect.model.ExtraExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExtraExperienceController {

    @Autowired
    private IExtraExperience iExtraExperience;

    @PostMapping("/save")
    public void saveExperience(@RequestBody ExtraExperience extraExperience) {
        iExtraExperience.saveExperience(extraExperience);

    }

    @GetMapping("/list")
    public  List<ExtraExperience> getExperiences() {
        List<ExtraExperience> extraExperienceList = iExtraExperience.getExperience();
        return extraExperienceList;
    }

    @GetMapping("/find/{id}")
    public ExtraExperience findExperience(@PathVariable Long id) {
        ExtraExperience extraExperience = iExtraExperience.findExperience(id);
        return extraExperience;
    }

    @PutMapping("/update/{id}")
    public void updateExperience(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description
    ){
        //editar

        ExtraExperience extraExperience = iExtraExperience.findExperience(id);

        extraExperience.setTitle(title);
        extraExperience.setDescription(description);

        iExtraExperience.saveExperience(extraExperience);
    }


}
