package com.example.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
    public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;
   
}

