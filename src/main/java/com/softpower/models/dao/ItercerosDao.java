package com.softpower.models.dao;

import org.springframework.data.jpa.repository.Query;
import com.softpower.entities.Terceros;
import org.springframework.data.repository.CrudRepository;

public interface ItercerosDao extends CrudRepository<Terceros, Long> {
}
