package com.cyeproject.croissantbakery.croissant.service;

import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import com.cyeproject.croissantbakery.croissant.repository.CroissantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CroissantService {
    private final CroissantRepository croissantRepository;

    public CroissantService(CroissantRepository croissantRepository){
        this.croissantRepository=croissantRepository;
    }

    public Croissant createCroissant(Croissant croissant){
        //존재하는지 확인하고 없으면 save 후 return
        //있으면 비즈니스에러 던지기!
        return croissantRepository.save(croissant);
    }

    public Croissant updateCroissant(Long cNumber,Croissant croissant){
        //존재하는지 확인
        //
        croissant.setCroissantNumber(cNumber);
        Croissant temporary = croissantRepository.findById(cNumber).get();
        if (croissant.getCroissantName()==null){
            croissant.setCroissantName(temporary.getCroissantName());
        }
        if (croissant.getCroissantExplain()==null){
            croissant.setCroissantExplain(temporary.getCroissantExplain());
        }
        if (croissant.getPrice()==null){//croissant.getPrice()==null)){
            croissant.setPrice(temporary.getPrice());
        }
        if (croissant.getCalorie()==null){
            croissant.setCalorie(temporary.getCalorie());
        }
        return croissantRepository.save(croissant);
    }

    public Croissant findCroissant(Long cNumber){
        return croissantRepository.findById(cNumber).get();
    }

    public List<Croissant> findAllCroissant(){
        return croissantRepository.findAll();
    }

    public void outOfStockCroissant(Long cNumber){
        croissantRepository.deleteById(cNumber);
    }
}
