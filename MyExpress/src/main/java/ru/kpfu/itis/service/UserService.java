package ru.kpfu.itis.service;

import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.User;

/**
 * Created by Ilgiz on 03.05.2016.
 */
public interface UserService extends AbstractService<User> {
    User getByEmail(String email);

    void signUp(UserForm userForm);
}
