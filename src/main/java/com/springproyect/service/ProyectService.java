package com.springproyect.service;

import com.springproyect.apiService.IProyectService;
import com.springproyect.model.Proyect;
import com.springproyect.repository.ProyectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectService implements IProyectService {

    @Autowired
    private ProyectRepository proyectRepository;

    @Override
    public void saveProyect(Proyect project) {
        proyectRepository.save(project);
    }

    @Override
    public Proyect findProyect(Long id) {
        return proyectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proyect> getProyects() {
        return proyectRepository.findAll();
    }

    @Override
    public List<Proyect> getProyectsByUser(Long id_user) {
        return proyectRepository.findProyectsByUser_Id(id_user);
    }


}
