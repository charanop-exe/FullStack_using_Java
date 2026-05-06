package com.sample;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private List<Map<String, Object>> orders = new ArrayList<>();

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<?> createOrder() {
        try {
            List products = restTemplate.getForObject(
                "http://ProductServiceApplication/products", List.class);

            Map<String, Object> order = new HashMap<>();
            order.put("id", System.currentTimeMillis());
            order.put("products", products);

            orders.add(order);

            return ResponseEntity.ok(order);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch products");
        }
    }

    // ✅ READ ALL
    @GetMapping
    public List<Map<String, Object>> getOrders() {
        return orders;
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public Map<String, Object> getOrderById(@PathVariable long id) {
        return orders.stream()
                .filter(o -> ((Number) o.get("id")).longValue() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Map<String, Object> updateOrder(@PathVariable long id) {
        for (Map<String, Object> order : orders) {
            if (((Number) order.get("id")).longValue() == id) {

                // fetch latest products again
                List products = restTemplate.getForObject(
                    "http://ProductServiceApplication/products", List.class);

                order.put("products", products);
                return order;
            }
        }
        throw new RuntimeException("Order not found");
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable long id) {
        orders.removeIf(o -> ((Number) o.get("id")).longValue() == id);
        return "Order deleted";
    }
}