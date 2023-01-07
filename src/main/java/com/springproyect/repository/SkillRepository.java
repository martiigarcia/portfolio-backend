package com.springproyect.repository;

import com.springproyect.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findSkillsByUser_Id(Long id);
}
