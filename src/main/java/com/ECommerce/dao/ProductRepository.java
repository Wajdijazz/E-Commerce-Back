package com.ECommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ECommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
