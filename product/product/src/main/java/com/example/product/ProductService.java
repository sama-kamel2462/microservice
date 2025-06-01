package com.example.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public boolean checkProductAvililbitiy(String productId, int quantitiy)
    {
        Product product = ProductRepository.getProductById(productId);
        if(product == null ) return false;
        return product.getStock()>= quantitiy;

        }


        public Product getProduct(String id)
        {
            return ProductRepository.getProductById(id);
        }

}
