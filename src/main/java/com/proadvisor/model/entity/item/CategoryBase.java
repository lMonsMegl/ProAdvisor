package com.proadvisor.model.entity.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@MappedSuperclass
public abstract class CategoryBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NaturalId
    private String name;
    
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("parent")
    private List<Category> children;
    
    @ManyToOne
    @JsonIgnoreProperties("children")
    private Category parent;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean isMain;
}
