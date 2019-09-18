package com.proadvisor.model.entity.item;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Product extends Item {
    
    private String manufacture;
    
    private BigDecimal avgPrice;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private List<Store> stores;
}
