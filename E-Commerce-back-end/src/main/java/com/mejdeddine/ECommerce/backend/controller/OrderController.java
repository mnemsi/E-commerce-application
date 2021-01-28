package com.mejdeddine.ECommerce.backend.controller;


import com.mejdeddine.ECommerce.backend.model.Order;
import com.mejdeddine.ECommerce.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        orderService.save(order);
        return ResponseEntity.ok(order);
    }

}
