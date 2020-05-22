package com.football_field.football_field.Validator;

import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
          User user = (User) o;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"");
    }
}
