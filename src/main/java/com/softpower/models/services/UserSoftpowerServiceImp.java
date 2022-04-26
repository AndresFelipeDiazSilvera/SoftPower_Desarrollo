package com.softpower.models.services;

import com.softpower.entities.UserSoftPower;
import com.softpower.models.dao.IUserSoftpowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserSoftpowerServiceImp implements IUserSoftpowerService, UserDetailsService {

    @Autowired
    private IUserSoftpowerDao iUserSoftpowerDao;


    @Override
    public List<UserSoftPower> findAll() {
        return iUserSoftpowerDao.findAll();
    }



    @Override
    public void save(UserSoftPower userSoftPower) {
    iUserSoftpowerDao.save(userSoftPower);
    }

    @Override
    public void remove(Long id) {
    iUserSoftpowerDao.deleteById(id);
    }

    @Override
    public UserSoftPower findOne(Long id) {
        return iUserSoftpowerDao.findById(id).orElse(null);
    }

    @Override
    public UserSoftPower findById(Long id) {
        return  iUserSoftpowerDao.findById(id).orElse(null);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSoftPower user = iUserSoftpowerDao.findByUsername(username);

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));

        return new User(user.getUsername(), user.getPassword(), roles);
    }
}
