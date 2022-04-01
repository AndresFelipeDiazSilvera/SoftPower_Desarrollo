package com.softpower.models.services;

import com.softpower.entities.Producto;
import com.softpower.models.dao.IproductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImp implements IproductoService{
    @Autowired
    private IproductoDao iproductoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() { return (List<Producto>) iproductoDao.findAll();}

    @Override
    public void save(Producto producto) {
        iproductoDao.save(producto);
    }

    @Override
    public Producto findOne(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {iproductoDao.deleteById(id);}

    @Override
    public Producto findById(Long id) {
        return iproductoDao.findById(id).orElseThrow(() -> null);
    }

}
