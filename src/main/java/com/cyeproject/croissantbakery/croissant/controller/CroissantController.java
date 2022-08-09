package com.cyeproject.croissantbakery.croissant.controller;

import com.cyeproject.croissantbakery.croissant.dto.CroissantRequestDto;
import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import com.cyeproject.croissantbakery.croissant.mapper.CroissantMapper;
import com.cyeproject.croissantbakery.croissant.service.CroissantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bakery/croissant")
public class CroissantController {
    private final CroissantService croissantService;
    private final CroissantMapper croissantMapper;

    public CroissantController(CroissantService croissantService, CroissantMapper croissantMapper){
        this.croissantService=croissantService;
        this.croissantMapper=croissantMapper;
    }

    @PostMapping
    public ResponseEntity postCroissant(@RequestBody CroissantRequestDto croissantRequestDto){
        Croissant croissant= croissantMapper.croissantRequestDtoToCroissant(croissantRequestDto);
        Croissant result = croissantService.createCroissant(croissant);
        return new ResponseEntity<>(croissantMapper.croissantToCroissantResponseDto(result),HttpStatus.CREATED);
    }

    @GetMapping("/{croissant-number}")
    public ResponseEntity getCroissant(@PathVariable("croissant-number") Long cNumber){
        Croissant croissant = croissantService.findCroissant(cNumber);
        return new ResponseEntity<>(croissantMapper.croissantToCroissantResponseDto(croissant),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCroissantList(){
        List<Croissant> croissants = croissantService.findAllCroissant();
        return new ResponseEntity<>(croissants,HttpStatus.OK);
    }

    @PatchMapping("/{croissant-number}")
    public ResponseEntity patchCroissant(@PathVariable("croissant-number") Long cNumber,@RequestBody CroissantRequestDto croissantRequestDto){
        Croissant croissant= croissantMapper.croissantRequestDtoToCroissant(croissantRequestDto);
        Croissant result = croissantService.updateCroissant(cNumber,croissant);
        return new ResponseEntity<>(croissantMapper.croissantToCroissantResponseDto(result),HttpStatus.OK);
    }

    @DeleteMapping("/{croissant-number}")
    public ResponseEntity deleteCroissant(@PathVariable("croissant-number") Long cNumber){
        croissantService.outOfStockCroissant(cNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
