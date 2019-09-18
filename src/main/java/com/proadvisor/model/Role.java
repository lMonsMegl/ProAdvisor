package com.proadvisor.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    
    ADMIN(1), USER(2), UNAUTHORIZED(3);
    
    private Integer id;
    
    Role(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    @Override
    public String getAuthority() {
        return name();
    }
}