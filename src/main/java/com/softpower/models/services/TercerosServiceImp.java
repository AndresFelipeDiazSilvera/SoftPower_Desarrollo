package com.softpower.models.services;

import com.softpower.entities.Tercero;
import com.softpower.models.dao.ItercerosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TercerosServiceImp implements ItercerosService{
    @Autowired
    private ItercerosDao itercerosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tercero> findAll() { return (List<Tercero>) itercerosDao.findAll();}

    @Override
    public void save(Tercero tercero) {
        itercerosDao.save(tercero);
    }

    @Override
    public Tercero findOne(Long id) {
        return null;
    }
}
