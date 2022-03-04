package com.softpower.models.dao;

import org.springframework.data.jpa.repository.Query;
import com.softpower.entities.Marca;
import org.springframework.data.repository.CrudRepository;

public interface ImarcaDao extends CrudRepository<Marca, Long> {
}
