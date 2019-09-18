package com.proadvisor.model.dto;

import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CommentDto {
    
    @NotBlank
    private String title;
    
    @NotBlank
    private String text;
    
    @Min(1)
    @Max(10)
    private int rating;
    
}
