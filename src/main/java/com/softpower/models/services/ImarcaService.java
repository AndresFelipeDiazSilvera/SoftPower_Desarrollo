package com.softpower.models.services;

import com.softpower.entities.Marca;

import java.util.List;

public interface ImarcaService {
    public List<Marca> findAll();
    public void save(Marca marca);
    public Marca findOne(Long id);
 }
