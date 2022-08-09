package com.cyeproject.croissantbakery.croissant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CroissantRequestDto {
    private String croissantName;
    private String croissantExplain;
    private Long price;
    private Long calorie;
}
