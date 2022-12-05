package com.demo.productmicroservice.controller;


import com.demo.productmicroservice.dao.ProductDao;
import com.demo.productmicroservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductDao productDao ;

    @GetMapping
    public List<Product> productsList(){
        List<Product> products = productDao.findAll();
        return products;
    }

    @GetMapping( value = "/{id}")
    public Optional<Product> getAProduct(@PathVariable int id) {
        Optional<Product> product = productDao.findById(id);
        return product;
    }

}
