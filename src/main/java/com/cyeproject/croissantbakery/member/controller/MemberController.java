package com.cyeproject.croissantbakery.member.controller;

import com.cyeproject.croissantbakery.member.dto.MemberJoinDto;
import com.cyeproject.croissantbakery.member.dto.MemberLoginDto;
import com.cyeproject.croissantbakery.member.entity.Member;
import com.cyeproject.croissantbakery.member.mapper.MemberMapper;
import com.cyeproject.croissantbakery.member.service.MemberService;
import com.cyeproject.croissantbakery.security.PrincipalDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bakery/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService,MemberMapper mapper){
        this.memberService=memberService;
        this.mapper=mapper;
    }

    @PostMapping("/join")
    public ResponseEntity joinMember(@RequestBody MemberJoinDto memberJoinDto){
        Member member=mapper.memberJoinDtoToMember(memberJoinDto);
        String result = memberService.createdMember(member);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
/*
    @PostMapping("/login")
    public ResponseEntity loginMember(@RequestBody MemberLoginDto memberLoginDto){
        Member member=mapper.memberLoginDtoToMember(memberLoginDto);
        String result= memberService.changeStateToLoginMember(member);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
 */
    @PatchMapping("/logout")
    public ResponseEntity logoutMember(@AuthenticationPrincipal PrincipalDetails principalDetails){
        String result = memberService.logoutMember(principalDetails.getUsername());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/information")
    public ResponseEntity getMember(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        Member member = memberService.findVerifiedMember(principalDetails.getUsername());
        String result = member.getUsername()+"의 상태는 "+member.getMemberStatus()+" 입니다.";
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
