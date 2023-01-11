package com.springproyect.service;

import com.springproyect.apiService.IAcademicExperienceService;
import com.springproyect.model.AcademicExperience;
import com.springproyect.repository.AcademicExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicExperienceService implements IAcademicExperienceService {

    @Autowired
    private AcademicExperienceRepository academicExperienceRepository;

    @Override
    public void saveExperience(AcademicExperience academicExperience) {
        academicExperienceRepository.save(academicExperience);
    }

    @Override
    public AcademicExperience findExperience(Long id) {
        return academicExperienceRepository.findById(id).orElse(null);
    }

    @Override
    public List<AcademicExperience> getExperiences() {
        return academicExperienceRepository.findAll();
    }

    @Override
    public List<AcademicExperience> getExperienceByUser(Long id) {
        return academicExperienceRepository.findAcademicExperiencesByUser_Id(id);
    }

    @Override
    public void deleteAcademicExperience(Long id) {
//        AcademicExperience academicExperience = findExperience(id);
//        academicExperienceRepository.delete(academicExperience);
        academicExperienceRepository.deleteById(id);
    }
}
