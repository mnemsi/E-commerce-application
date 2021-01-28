package com.mejdeddine.ECommerce.backend.repository;


import com.mejdeddine.ECommerce.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
