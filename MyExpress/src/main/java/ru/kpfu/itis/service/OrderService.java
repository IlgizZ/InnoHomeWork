package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Order;

import java.util.List;

/**
 * Created by Ilgiz on 03.05.2016.
 */
public interface OrderService {
    boolean add(Order order);

    void delete(Long id);

    Order getByID(Long id);

    boolean update(Order order);

    List<Order> getAll();
}
