package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Category;
import ru.kpfu.itis.model.Item;

import java.util.List;

/**
 * Created by Ilgiz on 03.05.2016.
 */
public interface ItemService extends AbstractService<Item> {
    List<Item> getNewItems();
    List<Item> getByCategory(Category category);
}
