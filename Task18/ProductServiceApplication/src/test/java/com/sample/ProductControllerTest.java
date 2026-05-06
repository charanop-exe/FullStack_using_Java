package com.sample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; // ✅ FIXED
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.BeforeEach;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ✅ GET /products → should return empty initially
    @Test
    public void testGetProducts_Empty() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    // ✅ POST /products → add product
    @Test
    public void testAddProduct() throws Exception {
        mockMvc.perform(post("/products")
                .contentType("application/json")
                .content("{\"name\":\"Laptop\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg").value("Product added"));
    }

    // ✅ GET /products → should return data
    @Test
    public void testGetProducts_NotEmpty() throws Exception {

        // First add product
        mockMvc.perform(post("/products")
                .contentType("application/json")
                .content("{\"name\":\"Phone\"}"));

        // Then check
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @BeforeEach
    void setup() throws Exception {
        // clear existing data
        mockMvc.perform(delete("/products/clear"));
    }
}