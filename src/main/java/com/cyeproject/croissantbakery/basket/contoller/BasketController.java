package com.cyeproject.croissantbakery.basket.contoller;

import com.cyeproject.croissantbakery.basket.repository.BasketRepository;
import com.cyeproject.croissantbakery.basket.service.BasketService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bakery/basket")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService){
        this.basketService=basketService;
    }

    @PostMapping
    public ResponseEntity postBasket(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllBasket(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /*
    @PatchMapping("")
    public ResponseEntity patchBasket(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity deleteBasket(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */
}
