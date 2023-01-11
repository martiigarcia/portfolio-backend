package com.springproyect.apiService;

import com.springproyect.model.Skill;

import java.util.List;

public interface ISkillService {
    void saveSkill(Skill skill);

    Skill findSkill(Long id);

    List<Skill> getSkill();

    List<Skill> getSkillsByUser(Long id);

    void deleteSkill(Long id);

}
