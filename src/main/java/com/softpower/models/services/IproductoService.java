package com.softpower.models.services;


import com.softpower.entities.Producto;

import java.util.List;

public interface IproductoService {
    public List<Producto> findAll();
    public void save(Producto producto);
    public Producto findOne(Long id);

    void remove(Long id);

    Producto findById(Long id);
}
