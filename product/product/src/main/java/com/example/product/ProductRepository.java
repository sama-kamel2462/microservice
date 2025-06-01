package com.example.product;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRepository {

    private static ConcurrentHashMap<String, Product> productMap = new ConcurrentHashMap<>();

    static {
        productMap.put("P1", new Product("P1", "Laptop", 1200.0, 10));
        productMap.put("P2", new Product("P2", "Phone", 800.0, 25));
        productMap.put("P3", new Product("P3", "Tablet", 450.0, 15));
        productMap.put("P4", new Product("P4", "Monitor", 300.0, 12));
        productMap.put("P5", new Product("P5", "Keyboard", 50.0, 50));
        productMap.put("P6", new Product("P6", "Mouse", 30.0, 60));
        productMap.put("P7", new Product("P7", "Printer", 200.0, 8));
        productMap.put("P8", new Product("P8", "Webcam", 90.0, 20));
        productMap.put("P9", new Product("P9", "Headphones", 70.0, 40));
        productMap.put("P10", new Product("P10", "Speakers", 110.0, 18));
    }

    public static Product getProductById(String id) {
        return productMap.get(id);
    }

    public static ConcurrentHashMap<String, Product> getAllProducts() {
        return productMap;
    }

    public static void DeleteProduct(String id)
    {
        productMap.remove(id);
    }


    
}
