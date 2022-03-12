package com.softpower.models.services;


import com.softpower.entities.Tercero;

import java.util.List;

public interface IterceroService {
    public List<Tercero> findAll();

    public void save(Tercero tercero);

    public Tercero findOne(Long id);
}

