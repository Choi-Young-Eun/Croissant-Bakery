package com.cyeproject.croissantbakery.order.service;

import com.cyeproject.croissantbakery.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

}
