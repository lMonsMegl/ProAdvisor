package com.proadvisor.model.converter;

import com.proadvisor.model.Role;
import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoleEnumIdConverter implements AttributeConverter<Role, Integer> {
    
    private HashMap<Integer, Role> roles;
    
    public RoleEnumIdConverter() {
        roles = new HashMap<>();
        for (Role role : Role.values()) {
            roles.put(role.getId(), role);
        }
    }
    
    @Override
    public Integer convertToDatabaseColumn(Role attribute) {
        return attribute.getId();
    }
    
    @Override
    public Role convertToEntityAttribute(Integer dbData) {
        return roles.get(dbData);
    }
}
