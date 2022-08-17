package com.cyeproject.croissantbakery.member.mapper;

import com.cyeproject.croissantbakery.member.dto.MemberJoinDto;
import com.cyeproject.croissantbakery.member.dto.MemberLoginDto;
import com.cyeproject.croissantbakery.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberJoinDtoToMember(MemberJoinDto memberPostDto);
    Member memberLoginDtoToMember(MemberLoginDto memberPostDto);
}
