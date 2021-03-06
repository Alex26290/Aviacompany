package org.aviacompany.utils;

import org.aviacompany.UsersDaoImpl;
import org.aviacompany.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UsersDaoImpl userDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userDao.getUserByEmail(user.getEmail())!=null) {
            errors.rejectValue("email","", "This email is already in use");
        }
    }
}
