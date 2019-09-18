package com.proadvisor.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class MenuDishDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String ingredients;
    @NotNull
    private BigDecimal price;
    private MultipartFile image;
    
    private long dishId;
}
