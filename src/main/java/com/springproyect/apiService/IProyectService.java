package com.springproyect.apiService;

import com.springproyect.model.Proyect;

import java.util.List;

public interface IProyectService {

    void saveProyect(Proyect project);

    Proyect findProyect(Long id);

    List<Proyect> getProyects();

    public List<Proyect> getProyectsByUser(Long id_user);

    void deleteProyect(Long id);
}
