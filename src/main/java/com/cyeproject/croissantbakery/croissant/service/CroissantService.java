package com.cyeproject.croissantbakery.croissant.service;

import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import com.cyeproject.croissantbakery.croissant.repository.CroissantRepository;
import com.cyeproject.croissantbakery.exception.BusinessLogicException;
import com.cyeproject.croissantbakery.exception.ExceptionCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CroissantService {
    private final CroissantRepository croissantRepository;

    public CroissantService(CroissantRepository croissantRepository){
        this.croissantRepository=croissantRepository;
    }

    public Croissant createCroissant(Croissant croissant){
        verifyCroissantName(croissant.getCroissantName());
        return croissantRepository.save(croissant);
    }

    public Croissant updateCroissant(Long cNumber,Croissant croissant){
        croissant.setCroissantNumber(cNumber);
        Croissant temporary = findVerifiedCroissant(cNumber);

        Optional.ofNullable(croissant.getCroissantName())
                .ifPresent(name -> temporary.setCroissantName(name));
        Optional.ofNullable(croissant.getCroissantExplain())
                .ifPresent(explain -> temporary.setCroissantExplain(explain));
        Optional.ofNullable(croissant.getPrice())
                .ifPresent(price -> temporary.setPrice(price));
        Optional.ofNullable(croissant.getCalorie())
                .ifPresent(calorie -> temporary.setCalorie(calorie));

        return croissantRepository.save(temporary);
    }

    public Croissant findCroissant(Long cNumber){
        return findVerifiedCroissant(cNumber);
    }

    public List<Croissant> findAllCroissant(){
        return croissantRepository.findAll();
    }

    public void outOfStockCroissant(Long cNumber){
        Croissant croissant = findVerifiedCroissant(cNumber);
        croissant.setCroissantStatus(Croissant.CroissantStatus.CROISSANT_NOT_EXIST);
        croissantRepository.save(croissant);
    }

    private Croissant findVerifiedCroissant(Long cNumber){
        Optional<Croissant> croissant = croissantRepository.findById(cNumber);
        Croissant findCroissant = croissant.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.NOT_FOUND));
        return findCroissant;
    }

    private void verifyCroissantName(String name){
        Optional<Croissant> croissant = croissantRepository.findByCroissantName(name);
        if(croissant.isPresent())
                throw new BusinessLogicException(ExceptionCode.ALREADY_EXISTS);
    }
}
