package com.proadvisor.model.entity.item;

import com.proadvisor.model.entity.common.City;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class Institution extends Item {
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    private City city;
    
    private String url;
    
    private String address;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;
}