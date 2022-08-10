package com.cyeproject.croissantbakery.croissant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Croissant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long croissantNumber;
    private String croissantName;
    private String croissantExplain;
    private Long price;
    private Long calorie;

    @Enumerated(value=EnumType.STRING)
    //@Column
    private CroissantStatus croissantStatus = CroissantStatus.CROISSANT_EXIST;

    public enum CroissantStatus {
        CROISSANT_EXIST("in_stock"),
        CROISSANT_NOT_EXIST("out_stock"),
        CROISSANT_BAKING("be_baking");

        @Getter
        private String status;

        CroissantStatus(String status) {
            this.status = status;
        }
    }
}
