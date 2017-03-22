package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.Item;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.ItemService;
import ru.kpfu.itis.service.OrderService;
import ru.kpfu.itis.util.BasketUtil;
import ru.kpfu.itis.util.CartItem;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 09.05.2016.
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    private final double E = 0.001;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
//    @Secured(isAuth ?)
    public String pageRender(ModelMap map, HttpSession httpSession) {
        Double subTotal = new Double(0);
        Double ecoTax = new Double(13);
        Double total = new Double(0);
        BasketUtil basket =
                ((BasketUtil) httpSession.getAttribute("cart"));
        if (basket != null) {
            List<CartItem> items = new ArrayList<>();
            List<BasketUtil.ItemId> id = basket.getAllId();
            for (int i = 0; i < id.size(); i++) {
                items.add(new CartItem(itemService.getByID(id.get(i).getId()), id.get(i).getCount()));
            }
            for (CartItem cartItem : items) {
                subTotal += (cartItem.getItem().getPrice() * cartItem.getCount());
            }
            total = subTotal * ecoTax / 100 + subTotal;
            map.put("CartItems", items);
            map.put("SubTotal", subTotal);
            map.put("EcoTax", ecoTax);
            map.put("Total", total);
            if (total < E) {
                return "order?empty_basket=true";
            }
            return "order";
        }
        return "order?empty_basket=true";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newOrder(@RequestParam(value = "sum", required = false) double sum, HttpSession httpSession) {
        Order order;
        BasketUtil basket =
                ((BasketUtil) httpSession.getAttribute("cart"));
        if (basket != null) {
            order = new Order();
            order.setUser(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));

            order.setSum(sum);
            List<Item> items = new ArrayList();
            for (BasketUtil.ItemId itemId : basket.getAllId()) {
                items.add(itemService.getByID(itemId.getId()));
            }
//            basket.getAllId().forEach(itemId -> {
//                items.add(itemService.getByID(itemId.getId()));
//            });
            order.setItems(items);
            orderService.add(order);
            httpSession.removeAttribute("cart");
            return "redirect:/shop/home?order=success";
        }
        return "redirect:/shop/home?order=error";

    }

}
