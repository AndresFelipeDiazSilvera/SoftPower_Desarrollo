package com.softpower.models.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.softpower.entities.Marca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ImarcaDao extends CrudRepository<Marca, Long> {
}
