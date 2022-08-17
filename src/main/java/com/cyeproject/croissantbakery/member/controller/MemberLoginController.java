package com.cyeproject.croissantbakery.member.controller;

import com.cyeproject.croissantbakery.member.dto.MemberLoginDto;
import com.cyeproject.croissantbakery.member.entity.Member;
import com.cyeproject.croissantbakery.member.mapper.MemberMapper;
import com.cyeproject.croissantbakery.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class MemberLoginController {

    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberLoginController(MemberService memberService,MemberMapper mapper){
        this.memberService=memberService;
        this.mapper=mapper;
    }


    //로그인한 정보 가져오는 거 다시 보기! 인증 후 정보 가져오기
    @PostMapping
    public ResponseEntity loginMember(@RequestBody MemberLoginDto memberLoginDto){
        Member member=mapper.memberLoginDtoToMember(memberLoginDto);
        String result= memberService.changeStateToLoginMember(member);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
