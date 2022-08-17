package com.cyeproject.croissantbakery.basket.enitity;

import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@IdClass(BasketID.class)
@Entity
public class Basket {
    /*
    @Id
    @Column(name="member_id")
    private String memberCode;

    @ManyToOne
    @MapsId
    @JoinColumn(name="member_id")
    private Member member;
    */
    @Id
    @Column(name="croissant_id")
    private Long croissantId;

    @ManyToOne
    @MapsId
    @JoinColumn(name="croissant_id")
    private Croissant croissant;

    private Long croissantSize;
}
