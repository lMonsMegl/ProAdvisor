package com.proadvisor;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerUtils {
    
    public static Map<String, String> convertBindingResultToMap(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage, (k1, k2) -> k1 + ", " + k2));
    }
    
}
