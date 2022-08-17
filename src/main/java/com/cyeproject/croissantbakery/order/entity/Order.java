package com.cyeproject.croissantbakery.order.entity;

import com.cyeproject.croissantbakery.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="croissant_order")
public class Order {
    @Id
    private Long orderId;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
    //private List<OrderCroissant> croissants;
    private Long totalPrice;

    @Enumerated(value= EnumType.STRING)
    private OrderStatus orderStatus;

    public enum OrderStatus {
        ORDER_REGISTER("register"), //주문 등록. 들어감
        ORDER_ACCEPT("accept"), //주문 확인
        ORDER_PREPARE("prepare"), //주문 준비중
        ORDER_COMPLETE("complete"); //완료

        @Getter
        private String status;

        OrderStatus(String status) {
            this.status = status;
        }
    }
}
