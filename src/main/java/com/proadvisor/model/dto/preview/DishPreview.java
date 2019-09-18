package com.proadvisor.model.dto.preview;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishPreview {
    
    private Long id;
    
    private String name;
    
    private String description;
    
}
