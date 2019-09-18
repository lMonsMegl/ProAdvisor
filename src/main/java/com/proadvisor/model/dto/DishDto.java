package com.proadvisor.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class DishDto {
    
    private String name;
    
    private String description;
    
    private String ingredients;
    
    private MultipartFile image;
}
