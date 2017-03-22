package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.Category;
import ru.kpfu.itis.model.Item;
import ru.kpfu.itis.service.impl.ItemServiceImpl;
import ru.kpfu.itis.service.impl.CategoryServiceImpl;

@Controller
public class AdminController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String pageRender() {
        return "admin/admin";
    }

    @RequestMapping(value = "admin/addcategory", method = RequestMethod.POST)
    public String addCategory(@RequestParam("name") String name) {
        Category category = new Category(name);
        categoryService.add(category);
        return "admin/admin";
    }

    @RequestMapping(value = "admin/additem", method = RequestMethod.POST)
    public String addItem(@RequestParam("name") String name, @RequestParam("price") int price,
                          @RequestParam("description") String descript, @RequestParam("category") String categor,
                          @RequestParam("count") int count) {
        Item item = new Item(name);
        item.setRecom(1);
        item.setPrice(Double.valueOf(price));
        item.setDescription(descript);
        item.setCategory(categoryService.getByName(categor));
        item.setCount(count);
        itemService.add(item);
        return "admin/admin";
    }
}
