package com.proadvisor.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Data
public class ShowplaceDto {
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
    
    private MultipartFile image;
    
    //TODO
//    private List<MultipartFile> image;
    
    private String url;
    
    private String address;
}
