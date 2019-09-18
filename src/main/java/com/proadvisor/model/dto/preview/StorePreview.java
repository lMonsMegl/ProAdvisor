package com.proadvisor.model.dto.preview;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StorePreview {
    
    private Long id;
    
    private String name;
    
    private String description;
    
    private double rating;
    
    private String mainImage;
    
    private long commentsCount;
    
    private long itemViewingCount;
}
