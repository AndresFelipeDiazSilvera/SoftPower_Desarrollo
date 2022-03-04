package com.softpower.models.services;

import com.softpower.entities.Movimiento;
import com.softpower.entities.Producto;

import java.util.List;

public interface IproductoService {
    public List<Producto> findAll();
}
