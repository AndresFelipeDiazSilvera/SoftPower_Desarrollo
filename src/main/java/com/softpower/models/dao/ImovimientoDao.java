package com.softpower.models.dao;

import org.springframework.data.jpa.repository.Query;
import com.softpower.entities.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface ImovimientoDao  extends CrudRepository<Movimiento, Long> {
}
