package com.example.spring_boot_rest_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_boot_rest_api.entity.Order;
import com.example.spring_boot_rest_api.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Create order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Update order
    public Order updateOrder(Long id, Order order) {

        Order existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder != null) {

            existingOrder.setOrderNumber(order.getOrderNumber());
            existingOrder.setQuantity(order.getQuantity());
            existingOrder.setProduct(order.getProduct());

            return orderRepository.save(existingOrder);
        }

        return null;
    }

    // Delete order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // Find orders by order number using custom @Query
    public List<Order> findOrdersByOrderNumber(String orderNumber) {
        return orderRepository.findOrdersByOrderNumber(orderNumber);
    }
}