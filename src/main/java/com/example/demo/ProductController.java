package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public void add(@RequestBody Product product){
        productService.save(product);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }
    @GetMapping("/products/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }
}
