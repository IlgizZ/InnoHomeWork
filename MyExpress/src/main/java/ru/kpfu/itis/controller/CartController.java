package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.service.impl.ItemServiceImpl;
import ru.kpfu.itis.util.BasketUtil;
import ru.kpfu.itis.util.CartItem;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop/cart")
public class CartController {

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
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
        }
        map.put("SubTotal", subTotal);
        map.put("EcoTax", ecoTax);
        map.put("Total", total);

        return "cart";
    }

    @RequestMapping(value = "/remove_item", method = RequestMethod.POST)
    @ResponseBody
    public String removeItem(HttpSession httpSession, @RequestParam(value = "id") String id) {
        BasketUtil basket =
                ((BasketUtil) httpSession.getAttribute("cart"));
        if (basket != null) {
            basket.removeItemId(Integer.parseInt(id));
        }
        httpSession.setAttribute("cart", basket);
        return "ok";
    }


    @RequestMapping(value = "/update_item_count", method = RequestMethod.POST)
    @ResponseBody
    public String updateItemCount(HttpSession httpSession, @RequestParam(value = "id") String id,
                                  @RequestParam(value = "count") String count) {
        BasketUtil basket =
                ((BasketUtil) httpSession.getAttribute("cart"));
        if (basket != null) {
            basket.setItemCountByID(Long.valueOf(id), Integer.valueOf(count));
        }
        httpSession.setAttribute("cart", basket);
        return "ok";
    }
}
