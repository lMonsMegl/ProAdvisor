package com.proadvisor.model.entity.menu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proadvisor.model.entity.menu.MenuChapter;
import com.proadvisor.model.entity.menu.MenuDish;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MenuSubchapter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NaturalId
    private String name;

    private int number;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties("menuSubchapters")
    @NaturalId
    private MenuChapter menuChapter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuSubchapter", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("menuSubchapter")
    private List<MenuDish> menuDishes;
}
