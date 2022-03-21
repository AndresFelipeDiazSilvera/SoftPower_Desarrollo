package com.softpower.models.services;

import com.softpower.entities.Movimiento;

import java.util.List;

public interface ImovimientoService {
    public List<Movimiento> findAll();
    public void save(Movimiento movimiento);
    public Movimiento findOne(Long id);

    void remove(Long id);
}
