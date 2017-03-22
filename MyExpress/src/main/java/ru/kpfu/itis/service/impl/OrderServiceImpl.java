package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.repository.OrderRepository;
import ru.kpfu.itis.service.OrderService;

import java.util.List;

/**
 * Created by Ilgiz on 04.05.2016.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }

    @Override
    public Order getByID(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public boolean update(Order order) {
        orderRepository.save(order);
        return true;
    }

    @Override
    public boolean add(Order order) {
        orderRepository.save(order);
        return true;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
