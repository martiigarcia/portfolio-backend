package com.springproyect.repository;

import com.springproyect.model.AcademicExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicExperienceRepository extends JpaRepository<AcademicExperience, Long> {

    List<AcademicExperience> findAcademicExperiencesByUser_Id(Long id);
}
