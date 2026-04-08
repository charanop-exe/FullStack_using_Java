package com.example.ordersystem.model;

public class Order {

    private int orderId;
    private double amount;
    private String status;

    public Order() {}

    public Order(int orderId, double amount, String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}