package com.cyeproject.croissantbakery.croissant.mapper;

import com.cyeproject.croissantbakery.croissant.dto.CroissantRequestDto;
import com.cyeproject.croissantbakery.croissant.dto.CroissantResponseDto;
import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CroissantMapper {
    Croissant croissantRequestDtoToCroissant(CroissantRequestDto croissantRequestDto);
    CroissantResponseDto croissantToCroissantResponseDto(Croissant croissant);
}
