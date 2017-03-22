package ru.kpfu.itis.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.UserRole;

import static org.springframework.web.util.HtmlUtils.htmlEscape;

public class UserFormToUserTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserForm form) {
        if (form == null) {
            return null;
        }
        User user = new User();
        user.setEmail(htmlEscape(form.getEmail()));
        user.setRole(UserRole.ROLE_ADMIN);
        user.setName(htmlEscape(form.getName()));
        user.setPassword(encoder.encode(form.getPassword()));
        return user;
    }
}
