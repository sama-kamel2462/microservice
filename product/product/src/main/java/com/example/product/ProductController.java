package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/checkAvilibity")
    ResponseEntity<String> checkProductAvililbitiy(@RequestBody ProductRequest productRequest)
    {

       boolean b= productService.checkProductAvililbitiy(productRequest.productId, productRequest.getQuantitiy());

       if(!b)
       {
        throw new ErrorResponseException(HttpStatus.NOT_FOUND);
       }

       return new ResponseEntity<String>("product is exist",HttpStatus.FOUND);

    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id)
    {
        return productService.getProduct(id);
    }




}
