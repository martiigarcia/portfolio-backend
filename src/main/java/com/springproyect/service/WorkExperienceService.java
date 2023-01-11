package com.springproyect.service;

import com.springproyect.apiService.IWorkExperienceService;
import com.springproyect.model.WorkExperience;
import com.springproyect.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceService implements IWorkExperienceService {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @Override
    public void saveExperience(WorkExperience workExperience) {
        workExperienceRepository.save(workExperience);
    }

    @Override
    public WorkExperience findExperience(Long id) {
        return workExperienceRepository.findById(id).orElse(null);
    }

    @Override
    public List<WorkExperience> getExperiences() {
        return workExperienceRepository.findAll();
    }

    @Override
    public List<WorkExperience> getExperienceByUser(Long id) {
        return workExperienceRepository.findExtraExperiencesByUser_Id(id);
    }

    @Override
    public void deleteWorkExperience(Long id) {
        workExperienceRepository.deleteById(id);
    }
}
