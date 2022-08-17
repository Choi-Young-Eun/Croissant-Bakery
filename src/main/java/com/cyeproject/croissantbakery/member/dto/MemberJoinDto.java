package com.cyeproject.croissantbakery.member.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class MemberJoinDto {
    //@NotBlank
    //영어랑 숫자로 이루어져있어야함
    //private String memberCode;
    @NotBlank
    //8자 이상 15자 이하여야함
    private String password;
    @NotBlank
    //한글이어야함
    private String username;
    @NotBlank
    //핸드폰번호 형식이어야함
    private String phone;
    @NotBlank
    @Email
    private String email;
}
