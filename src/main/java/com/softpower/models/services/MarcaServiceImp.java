package com.softpower.models.services;

import com.softpower.entities.Marca;
import com.softpower.models.dao.ImarcaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarcaServiceImp implements ImarcaService {
    @Autowired
    private ImarcaDao imarcaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Marca> findAll() { return (List<Marca>) imarcaDao.findAll();}

    @Override
    public void save(Marca marca) {
    imarcaDao.save(marca);
    }

    @Override
    public Marca findOne(Long id) {
        return null;
    }
}
