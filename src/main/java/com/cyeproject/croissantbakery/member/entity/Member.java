package com.cyeproject.croissantbakery.member.entity;

import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    private String memberCode;
    private String password;
    private String memberName;
    private String phone;
    private String email;

    @Enumerated(value= EnumType.STRING)
    //@Column
    private MemberStatus memberStatus = MemberStatus.MEMBER_JOIN;

    public enum MemberStatus {
        MEMBER_JOIN("join"),
        MEMBER_LOGOUT("logout"),
        MEMBER_LOGIN("logoin"),
        MEMBER_WITHDRAWAL("withdrawal");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
