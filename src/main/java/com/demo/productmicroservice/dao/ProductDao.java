package com.demo.productmicroservice.dao;

import com.demo.productmicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
}
