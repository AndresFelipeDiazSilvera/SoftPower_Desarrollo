package com.softpower.models.dao;

import com.softpower.entities.UserSoftPower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserSoftpowerDao extends JpaRepository<UserSoftPower,Long> {
    UserSoftPower findByUsername(String username);
}
