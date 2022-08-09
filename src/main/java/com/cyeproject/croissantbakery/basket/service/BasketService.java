package com.cyeproject.croissantbakery.basket.service;

import com.cyeproject.croissantbakery.basket.enitity.Basket;
import com.cyeproject.croissantbakery.basket.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository){
        this.basketRepository=basketRepository;
    }

    public Basket createBasket(){
        return null;
    }

    public List<Basket> findAllBasket(){
        return null;
    }

    public Basket updateBasket(){
        return null;
    }

    public void deleteBasket(){
    }
}
