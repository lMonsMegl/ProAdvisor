package com.proadvisor.controller.authorization;

import com.proadvisor.ControllerUtils;
import com.proadvisor.model.dto.RegistrationDto;
import com.proadvisor.model.entity.common.User;
import com.proadvisor.service.UserService;
import com.proadvisor.validation.RegistrationValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Map;

@RestController()
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationValidator registrationValidator;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(registrationValidator);
    }
    
    @PostMapping("/user/add")
    public ResponseEntity<Map<String, String>> addUser(@Valid RegistrationDto form,
                                                       BindingResult bindingResult) {
        Map<String, String> errors = ControllerUtils.convertBindingResultToMap(bindingResult);
        User user = new User();
        BeanUtils.copyProperties(form, user);
        if (userService.hasUserWithEmail(user.getEmail())) {
            errors.put("user.email.duplicate", "User with such email already exists");
        }
        if (userService.hasUserWithLogin(user.getLogin())) {
            errors.put("user.login.duplicate", "User with such login already exists");
        }
        
        if (errors.size() != 0) {
            return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
        }
        if (!userService.addNewUser(user)) {
            errors.put("user.unknown", "Unknown error");
            return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }
    
}
