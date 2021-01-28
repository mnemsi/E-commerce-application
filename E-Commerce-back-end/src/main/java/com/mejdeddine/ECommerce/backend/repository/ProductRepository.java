package com.mejdeddine.ECommerce.backend.repository;

import com.mejdeddine.ECommerce.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
