package com.softpower.models.services;

import com.softpower.entities.Tercero;
import com.softpower.models.dao.IterceroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TerceroServiceImp implements IterceroService {
    @Autowired
    private IterceroDao iterceroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tercero> findAll() { return (List<Tercero>) iterceroDao.findAll();}

    @Override
    public void save(Tercero tercero) {
        iterceroDao.save(tercero);
    }

    @Override
    public Tercero findOne(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {iterceroDao.deleteById(id);}
}
