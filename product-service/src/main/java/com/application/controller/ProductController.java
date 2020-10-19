package com.application.controller;

import com.application.model.Product;
import com.application.model.User;
import com.application.service.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

//    @Autowired
//    private RestTemplate template;

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/{userId}")
    public ResponseEntity<?> findProductForUser(@PathVariable("userId") String userId){

        // Call the user-service microservice
        //User user = template.getForObject("http://USER-SERVICE/api/v1/user/"+userId, User.class);
        User user = null;
        user = userFeign.getUser(userId);
        System.out.println("User :: "+user);
        Product prod = new Product();
        prod.setUser(user);

        return ResponseEntity.ok(prod);
    }

}
