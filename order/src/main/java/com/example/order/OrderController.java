package com.example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate; 

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest)
    {
        String productUrl ="http://localhost:8081/product/" + orderRequest.getProductId();

     Product  product=   restTemplate.getForObject(productUrl,Product.class);

     if(product ==null )
     {
        return new ResponseEntity<String>("the product not avilible",HttpStatus.NOT_FOUND);
     }

     if(product.getStock()<orderRequest.getQuantity())
     {
        return new ResponseEntity<>("the amount is not avilible",HttpStatus.BAD_REQUEST);
     }
      double amount = product.getPrice() * orderRequest.getQuantity();

      PaymentRequest paymentRequest = new PaymentRequest(orderRequest.getUserId(), amount);

      String paymentUrl ="http://localhost:8082/payment";

      ResponseEntity<String> paymentResponse = restTemplate.postForEntity(paymentUrl,paymentRequest, String.class);

      if(paymentResponse.getStatusCode()!=HttpStatus.OK )
      {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed.");
      }

       return ResponseEntity.ok("Order placed successfully. Payment ID: " + paymentResponse.getBody());
      





    }

}
