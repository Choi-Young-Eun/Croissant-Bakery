package com.cyeproject.croissantbakery.croissant.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CroissantPostDto {
    @NotBlank
    private String croissantName;
    @NotBlank
    //무조건 한글로..?
    private String croissantExplain;
    @Min(3000)
    private Long price;
    @Positive
    private Long calorie;
}