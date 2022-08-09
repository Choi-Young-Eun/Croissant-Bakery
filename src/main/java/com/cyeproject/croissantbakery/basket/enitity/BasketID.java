package com.cyeproject.croissantbakery.basket.enitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BasketID implements Serializable {
    //@EqualsAndHashCode.Include
    //private Long memberId;
    @EqualsAndHashCode.Include
    private Long croissantId;
}