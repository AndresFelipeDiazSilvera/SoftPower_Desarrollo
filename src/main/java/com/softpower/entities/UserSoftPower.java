package com.softpower.entities;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserSoftPower implements Serializable {
    private static final long serialVersionUID = 1L;

    public UserSoftPower() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name =  "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    public UserSoftPower(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
