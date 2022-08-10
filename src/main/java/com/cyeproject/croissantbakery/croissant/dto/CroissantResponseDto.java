package com.cyeproject.croissantbakery.croissant.dto;

import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CroissantResponseDto {
    private Long croissantNumber;
    private String croissantName;
    private String croissantExplain;
    private Long price;
    private Long calorie;
    private Croissant.CroissantStatus croissantStatus;
}
