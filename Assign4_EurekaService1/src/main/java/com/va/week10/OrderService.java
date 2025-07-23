package com.va.week10;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private  OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }
}
