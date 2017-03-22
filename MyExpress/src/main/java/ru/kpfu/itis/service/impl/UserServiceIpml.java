package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.UserRole;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;

import java.util.List;

import static org.springframework.web.util.HtmlUtils.htmlEscape;

/**
 * Created by Ilgiz on 03.05.2016.
 */
@Service
public class UserServiceIpml implements UserService {
    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void signUp(UserForm userForm) {
        User user = new User();
        user.setEmail(htmlEscape(userForm.getEmail()));
        user.setPassword(encoder.encode(userForm.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        user.setName(userForm.getName());
        userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findOneByName(name);
    }

    @Override
    public User getByID(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean update(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean add(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
