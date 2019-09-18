package com.proadvisor.model.entity.item;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Store extends Institution {
    
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> products;
}
