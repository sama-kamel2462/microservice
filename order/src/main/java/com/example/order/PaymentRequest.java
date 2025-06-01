package com.example.order;


public class PaymentRequest {
    private String userId;
    private double amount;

    public PaymentRequest() {}

    public PaymentRequest(String userId, double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
