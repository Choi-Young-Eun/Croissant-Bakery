package com.cyeproject.croissantbakery.croissant.dto;

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
}
