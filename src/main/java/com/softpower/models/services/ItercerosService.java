package com.softpower.models.services;

import com.softpower.entities.Producto;
import com.softpower.entities.Tercero;

import java.util.List;

public interface ItercerosService {
    public List<Tercero> findAll();

    public void save(Tercero tercero);

    public Tercero findOne(Long id);
}

