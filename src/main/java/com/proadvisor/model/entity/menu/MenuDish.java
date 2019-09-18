package com.proadvisor.model.entity.menu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proadvisor.model.entity.item.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Entity
public class MenuDish extends Item {
    
    private String ingredients;

    private BigDecimal price;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties("menuDishes")
    private MenuSubchapter menuSubchapter;
    
    private int weightGrams;
    
    @ManyToOne
    @JsonIgnore
    private Dish dish;
}
