package com.proadvisor.model.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proadvisor.model.entity.item.Item;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Data
@Entity
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String text;
    
    @Column(nullable = false)
    private int rating;
    
    private ZonedDateTime createdDateTime;
    
    @ManyToOne
    @JsonIgnore
    private Item item;
    
    @ManyToOne
    private User user;
    
    
}
