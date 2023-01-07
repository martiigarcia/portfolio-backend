package com.springproyect.repository;

import com.springproyect.model.Proyect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectRepository extends JpaRepository<Proyect, Long> {

    List<Proyect> findProyectsByUser_Id(Long id);
}