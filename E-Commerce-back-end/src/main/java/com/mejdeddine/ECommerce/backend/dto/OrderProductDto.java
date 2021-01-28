package com.mejdeddine.ECommerce.backend.dto;

import com.mejdeddine.ECommerce.backend.model.Product;
import lombok.Data;


@Data
public class OrderProductDto {
    private Product product;
    private Integer quantity;
}
