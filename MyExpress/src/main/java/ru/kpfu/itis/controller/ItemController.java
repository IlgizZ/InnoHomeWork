package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.service.impl.CategoryServiceImpl;
import ru.kpfu.itis.service.impl.ItemServiceImpl;

@Controller
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(value = "shop/item/{itemID}", method = RequestMethod.GET)
    public String pageRender(@PathVariable("itemID") String id, ModelMap map){
        map.put("categories", categoryService.getAll());
        map.put("newItems", itemService.getNewItems());
        map.put("Prod", itemService.getByID(Long.parseLong(id)));
        return "product-details";
    }
}