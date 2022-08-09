package com.cyeproject.croissantbakery.croissant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
