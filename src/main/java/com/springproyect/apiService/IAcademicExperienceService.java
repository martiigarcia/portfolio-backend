package com.springproyect.apiService;

import com.springproyect.model.AcademicExperience;

import java.util.List;

public interface IAcademicExperienceService {

    void saveExperience(AcademicExperience academicExperience);

    AcademicExperience findExperience(Long id);

    List<AcademicExperience> getExperiences();

    List<AcademicExperience> getExperienceByUser(Long id);

    void deleteAcademicExperience(Long id);
}
