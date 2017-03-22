package ru.kpfu.itis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFormValidator implements Validator {

    private static Pattern p = Pattern.compile("\\d+");
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (!validate(user.getEmail())) {
            errors.rejectValue("email", "", "Incorrect email!");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            errors.rejectValue("name", "", "Name can't be empty!");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "", "Password should be from 6 to 32 symbols!");
        }


    }
}
