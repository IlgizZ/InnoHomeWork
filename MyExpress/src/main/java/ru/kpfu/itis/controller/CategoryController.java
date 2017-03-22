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
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "shop/category/{category}", method = RequestMethod.GET)
    public String pageRender(@PathVariable("category") String category, ModelMap map) {
        try {
            map.put("list", itemService.getByCategory(categoryService.getByID(Long.valueOf((category)))));
            map.put("categories", categoryService.getAll());
            map.put("newItems", itemService.getNewItems());
            map.put("name", categoryService.getByID(Long.valueOf(category)).getName());
        } catch (Exception e) {
            return "redirect:/errors/404";
        }
        return "index";
    }
}
