package com.proadvisor.model.entity.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proadvisor.model.entity.common.Comment;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String name;
    
    private String description;
    
    @JsonIgnore
    private int summingRating;
    
    private double rating;
    
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Comment> comments;
    
    private long commentsCount;
    
    private long itemViewingCount;
    
    private String mainImage;
    
    @ElementCollection
    private List<String> images;
}