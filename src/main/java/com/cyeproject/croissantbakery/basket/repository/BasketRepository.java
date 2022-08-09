package com.cyeproject.croissantbakery.basket.repository;

import com.cyeproject.croissantbakery.basket.enitity.Basket;
import com.cyeproject.croissantbakery.basket.enitity.BasketID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, BasketID> {
}
