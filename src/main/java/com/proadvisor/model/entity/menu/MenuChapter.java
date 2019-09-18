package com.proadvisor.model.entity.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MenuChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NaturalId
    private String name;

    private int number;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonIgnore
    @NaturalId
    @JsonIgnoreProperties("menuChapters")
    private Menu menu;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuChapter", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("menuChapter")
    private List<MenuSubchapter> menuSubchapters;
}
