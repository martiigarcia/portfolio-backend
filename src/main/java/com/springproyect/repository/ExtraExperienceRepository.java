package com.springproyect.repository;

import com.springproyect.model.ExtraExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraExperienceRepository extends JpaRepository<ExtraExperience, Long> {

    List<ExtraExperience> findExtraExperiencesByUser_Id(Long id);
}
