package ru.kpfu.itis.service;

import java.util.List;

public interface AbstractService<T> {

    void delete(Long id);

    T getByName(String name);

    T getByID(Long id);

    boolean update(T obj);

    boolean add(T obj);

    List<T> getAll();
}
