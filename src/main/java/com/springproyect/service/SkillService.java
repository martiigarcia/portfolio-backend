package com.springproyect.service;

import com.springproyect.apiService.ISkillService;
import com.springproyect.model.Skill;
import com.springproyect.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public Skill findSkill(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public List<Skill> getSkill() {
        return skillRepository.findAll();
    }

    @Override
    public List<Skill> getSkillsByUser(Long id) {
        return skillRepository.findSkillsByUser_Id(id);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

}
