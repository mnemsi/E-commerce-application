package com.mejdeddine.ECommerce.backend.service;


import com.mejdeddine.ECommerce.backend.model.Order;
import com.mejdeddine.ECommerce.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }

    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
