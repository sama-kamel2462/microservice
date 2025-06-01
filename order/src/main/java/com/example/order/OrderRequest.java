package com.example.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequest {
    private String productId;
    private int quantity;
    private double amount;
    private String userId;
    // Getters and Setters
}