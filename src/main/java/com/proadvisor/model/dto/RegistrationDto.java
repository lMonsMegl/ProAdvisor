package com.proadvisor.model.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegistrationDto {
    
    @NotBlank(message = "Login must not be empty")
    @Size(min = 3, max = 40, message = "Size must be between 3 and 40")
    @Pattern(regexp = "^[a-z0-9_]*$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Login contains illegal symbols")
    private String login;
    
    @NotBlank(message = "Name must not be empty")
    @Size(min = 1, max = 100, message = "Size must be between 1 and 100")
    @Pattern(regexp = "\\p{IsAlphabetic}*", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Name contains illegal symbols")
    private String name;
    
    @NotBlank(message = "Surname must not be empty")
    @Size(min = 1, max = 100, message = "Size must be between 1 and 100")
    @Pattern(regexp = "\\p{IsAlphabetic}*", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Surname contains illegal symbols")
    private String surname;
    
    @NotBlank(message = "Email must not be empty")
    @Size(min = 5, max = 100, message = "Size must be between 5 and 100")
    @Pattern(regexp = "^([a-z0-9_.-]+)@([a-z0-9_.-]+)\\.([a-z.]{2,6})$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email contains illegal symbols")
    private String email;
    
    @NotBlank(message = "Password must not be empty")
    @Size(min = 5, max = 100, message = "Size must be between 5 and 100")
    private String password;
    
    @NotBlank(message = "Repeated password must not be empty")
    private String repeatPassword;
    
}