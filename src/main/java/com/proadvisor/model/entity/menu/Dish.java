package com.proadvisor.model.entity.menu;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    
    private String description;

    private String ingredients;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dish", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MenuDish> menuDishes;
    
    private String mainImage;
}
