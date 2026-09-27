package com.example.spring_boot_rest_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring_boot_rest_api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.orderNumber = :orderNumber")
    List<Order> findOrdersByOrderNumber(@Param("orderNumber") String orderNumber);
}