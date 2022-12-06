package com.demo.productmicroservice.controller;


import com.demo.productmicroservice.controller.util.ApiResponse;
import com.demo.productmicroservice.dao.ProductDao;
import com.demo.productmicroservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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

    @PostMapping
    public ApiResponse<Product> createProduct(@RequestBody Product p){
        return new ApiResponse<Product>(HttpStatus.OK.value(), "Product saved successfully ", productDao.save(p));
    }

    @PutMapping("/{id}")
    public ApiResponse<Product> updateProduct(@PathVariable("id") Integer id,@RequestBody Product p){
        Optional<Product> product = productDao.findById(id);
        if(Objects.isNull(product)) {
            return new ApiResponse<Product>(HttpStatus.NOT_FOUND.value(), "Product with id: "+id+ " not found", null);
        }
        p.setId(id);
        return new ApiResponse<Product>(
                HttpStatus.OK.value(),
                "Product updated successfully",
                productDao.save(p));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct(@PathVariable Integer id){
        if(Objects.isNull(productDao.findById(id))){
            return new ApiResponse<Void>(HttpStatus.NOT_FOUND.value(), "Product with id: "+id+ " not found", null);
        }
        productDao.deleteById(id);
        return new ApiResponse<Void>(HttpStatus.OK.value(), "Product deleted successfully", null);
    }


}
