package com.softpower.models.dao;

import org.springframework.data.jpa.repository.Query;
import com.softpower.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IproductoDao extends CrudRepository <Producto, Long> {
}
