package com.springproyect.apiService;

import com.springproyect.model.WorkExperience;

import java.util.List;

public interface IWorkExperienceService {

    void saveExperience(WorkExperience workExperience);

    WorkExperience findExperience(Long id);

    List<WorkExperience> getExperiences();

    List<WorkExperience> getExperienceByUser(Long id);

    void deleteWorkExperience(Long id);
}
