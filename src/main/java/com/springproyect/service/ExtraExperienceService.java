package com.springproyect.service;

import com.springproyect.apiService.IExtraExperience;
import com.springproyect.model.ExtraExperience;
import com.springproyect.repository.ExtraExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraExperienceService implements IExtraExperience {

    @Autowired
    private ExtraExperienceRepository extraExperienceRepository;

    @Override
    public void saveExperience(ExtraExperience extraExperience) {
        extraExperienceRepository.save(extraExperience);
    }

    @Override
    public ExtraExperience findExperience(Long id) {
        ExtraExperience extraExperience = extraExperienceRepository.findById(id).orElse(null);
        return extraExperience;
    }

    @Override
    public List<ExtraExperience> getExperience() {
        List<ExtraExperience> extraExperienceList = extraExperienceRepository.findAll();
        return extraExperienceList;
    }
}
