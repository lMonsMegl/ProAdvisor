package com.proadvisor.model.entity.menu;

import com.proadvisor.model.entity.item.Catering;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MenuChapter> menuChapters;

}
