package com.proadvisor.validation;

import com.proadvisor.model.dto.RegistrationDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationDto.class.equals(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        RegistrationDto registrationDto = (RegistrationDto) target;
        if (!registrationDto.getPassword().equals(registrationDto.getRepeatPassword())) {
            errors.rejectValue("repeatPassword", "DoesNotMatch","Repeated password must match password");
        }
    }
}
