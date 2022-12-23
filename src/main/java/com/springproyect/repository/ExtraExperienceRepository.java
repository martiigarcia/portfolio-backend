package com.springproyect.repository;

import com.springproyect.model.ExtraExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraExperienceRepository extends JpaRepository<ExtraExperience, Long> {
}
