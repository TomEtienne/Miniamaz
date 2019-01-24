package com.example.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="userauth")
public class UserAuthorities implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="role")
    private String role;

    public UserAuthorities(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
