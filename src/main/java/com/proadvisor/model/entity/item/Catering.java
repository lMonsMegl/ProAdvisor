package com.proadvisor.model.entity.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proadvisor.model.entity.menu.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Catering extends Institution {
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Menu menu;
}