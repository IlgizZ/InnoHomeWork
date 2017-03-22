package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.UserFormToUserTransformer;
import ru.kpfu.itis.util.UserFormValidator;

@Controller
public class SignInController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    private UserFormValidator validator = new UserFormValidator();

    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute UserForm userForm, BindingResult result, Model model) {
        User user = UserFormToUserTransformer.transform(userForm);
        model.addAttribute("user", user);
        if (userRepository.findOneByEmail(user.getEmail()) != null) {
            return "login?regError=2";
        }
        validator.validate(user, result);

        if (result.hasErrors()) {
            return "login?regError=1";
        } else {
            userService.signUp(userForm);
            return "redirect:/login";
        }
    }

}
