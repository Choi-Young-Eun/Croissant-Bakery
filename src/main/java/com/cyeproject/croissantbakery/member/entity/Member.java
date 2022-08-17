package com.cyeproject.croissantbakery.member.entity;

import com.cyeproject.croissantbakery.croissant.entity.Croissant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "member_pw")
    private String password;
    private String username;
    private String phone;
    private String email;
    private String roles; //USER, MANAGER, ADMIN

    //역할이 여러개 있다고 가정할껀가봐
    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    @Enumerated(value= EnumType.STRING)
    //@Column
    private MemberStatus memberStatus;

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
