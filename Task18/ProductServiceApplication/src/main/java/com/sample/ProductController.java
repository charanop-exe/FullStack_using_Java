package com.sample;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Map<String, Object>> products = new ArrayList<>();

    // CREATE
    @PostMapping
    public Map<String, String> addProduct(@RequestBody Map<String, Object> product) {
        product.put("id", System.currentTimeMillis());
        products.add(product);
        return Map.of("msg", "Product added");
    }

    // READ ALL
    @GetMapping
    public List<Map<String, Object>> getProducts() {
        return products;
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Map<String, Object> getProductById(@PathVariable long id) {
        return products.stream()
                .filter(p -> ((Number) p.get("id")).longValue() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Map<String, Object> updateProduct(@PathVariable long id,
                                             @RequestBody Map<String, Object> updatedProduct) {

        for (Map<String, Object> product : products) {
            if (((Number) product.get("id")).longValue() == id) {
                product.put("name", updatedProduct.get("name"));
                return product;
            }
        }
        throw new RuntimeException("Product not found");
    }

    // DELETE ALL (for test reset)
    @DeleteMapping("/clear")
    public String clearProducts() {
        products.clear();
        return "All products cleared";
    }

    // DELETE BY ID
    @DeleteMapping("/{id:[0-9]+}")
    public String deleteProduct(@PathVariable long id) {
        products.removeIf(p -> ((Number) p.get("id")).longValue() == id);
        return "Product deleted successfully";
    }
}