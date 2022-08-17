package com.cyeproject.croissantbakery.member.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class MemberLoginDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
