package com.example.spring_boot_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_rest_api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}