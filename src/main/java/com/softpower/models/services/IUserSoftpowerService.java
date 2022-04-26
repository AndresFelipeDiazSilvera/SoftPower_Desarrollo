package com.softpower.models.services;


import com.softpower.entities.UserSoftPower;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserSoftpowerService {

    public List<UserSoftPower> findAll();
    public void save(UserSoftPower userSoftPower);
    public void remove(Long id);
    public UserSoftPower findOne(Long id);
    UserSoftPower findById(Long id);


    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
