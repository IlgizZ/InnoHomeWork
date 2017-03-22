package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.service.impl.CategoryServiceImpl;
import ru.kpfu.itis.service.impl.ItemServiceImpl;
import ru.kpfu.itis.util.BasketUtil;
import ru.kpfu.itis.util.EmailSenderUtil;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(value = "/permission_denied")
    public String getAccessDenyPage() {
        return "access-deny";
    }

    @RequestMapping(value = "shop/home", method = RequestMethod.GET)
    public String pageRender(ModelMap map, HttpSession httpSession) {
        map.put("list", itemService.getAll());
        map.put("categories", categoryService.getAll());
        map.put("newItems", itemService.getNewItems());
        map.put("name", "Home");
        httpSession.setAttribute("cart", new BasketUtil());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redir() {
        return "redirect:shop/home";
    }

    @RequestMapping(value = "/contact-us", method = RequestMethod.GET)
    public String contact() {
        return "contact-us";
    }

    @RequestMapping(value = "/contact-us", method = RequestMethod.POST)
    public String emailPushed(@RequestParam("password") String password, @RequestParam("email") String email,
                              @RequestParam("subject") String subject, @RequestParam("message") String message) {

        try {
            EmailSenderUtil.getInstance().send(email, password, subject, message);
        } catch (MailException e) {
            return "redirect:contact-us?error=1";
        }
        return "redirect:contact-us?mess=1";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String pageRender() {
        return "/errors/404";
    }

    @RequestMapping(value = "/shop/addItem", method = RequestMethod.POST)
    @ResponseBody
    public String addItem(HttpSession httpSession, @RequestParam(value = "cont") String id) {
        BasketUtil basket =
                ((BasketUtil) httpSession.getAttribute("cart"));
        if (basket == null) {
            basket = new BasketUtil();
        }
        basket.addItemId(Integer.parseInt(id));
        httpSession.setAttribute("cart", basket);
        return "ok";
    }


}
