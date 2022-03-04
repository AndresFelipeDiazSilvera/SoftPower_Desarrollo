package com.softpower.models.services;

import com.softpower.entities.Movimiento;
import com.softpower.models.dao.ImovimientoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovimientoServiceImp implements ImovimientoService{
    @Autowired
    private ImovimientoDao imovimientoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> findAll() { return (List<Movimiento>) imovimientoDao.findAll(); }
}
