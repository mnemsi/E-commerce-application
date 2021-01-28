package com.mejdeddine.ECommerce.backend.controller;


import com.mejdeddine.ECommerce.backend.model.Product;
import com.mejdeddine.ECommerce.backend.service.ProductService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping({"/",""})
    public @NotNull Iterable<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(savedProduct);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id){
        Product deletedProduct = productService.getProduct(id);
        productService.deleteById(id);
        return ResponseEntity.ok(deletedProduct.toString() + "is Deleted");
    }
}
