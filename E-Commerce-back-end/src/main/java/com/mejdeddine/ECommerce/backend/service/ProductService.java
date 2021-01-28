package com.mejdeddine.ECommerce.backend.service;


import com.mejdeddine.ECommerce.backend.exception.ResourceFoundException;
import com.mejdeddine.ECommerce.backend.model.Product;
import com.mejdeddine.ECommerce.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceFoundException("Product not found"));
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(long id){
        productRepository.deleteById(id);
    }


}
