package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Category;
import ru.kpfu.itis.repository.CategoryRepository;
import ru.kpfu.itis.service.CategoryService;

import java.util.List;

/**
 * Created by Ilgiz on 04.05.2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public boolean add(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findOneByName(name);
    }

    @Override
    public Category getByID(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public boolean update(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
