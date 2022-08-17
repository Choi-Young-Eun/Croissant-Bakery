package com.cyeproject.croissantbakery.order.repository;

import com.cyeproject.croissantbakery.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
