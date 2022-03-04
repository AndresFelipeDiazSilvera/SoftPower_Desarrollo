package com.softpower.models.services;

import com.softpower.entities.Terceros;
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
    public List<Terceros> findAll() { return (List<Terceros>) itercerosDao.findAll();}
}
