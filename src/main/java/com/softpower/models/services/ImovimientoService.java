package com.softpower.models.services;

import com.softpower.entities.Marca;
import com.softpower.entities.Movimiento;

import java.util.List;

public interface ImovimientoService {
    public List<Movimiento> findAll();
}
