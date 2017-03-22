package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Category;
import ru.kpfu.itis.model.Item;
import ru.kpfu.itis.repository.ItemRepository;
import ru.kpfu.itis.service.ItemService;

import java.util.List;

/**
 * Created by Ilgiz on 03.05.2016.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getNewItems() {
        return itemRepository.findByRecom(Integer.valueOf(1));
    }

    @Override
    public List<Item> getByCategory(Category category) {
        return itemRepository.findAllByCategory(category);
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(id);
    }

    @Override
    public Item getByName(String name) {
        return itemRepository.findOneByName(name);
    }

    @Override
    public Item getByID(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public boolean update(Item item) {
        itemRepository.save(item);
        return true;
    }

    @Override
    public boolean add(Item item) {
        itemRepository.save(item);
        return true;
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}
