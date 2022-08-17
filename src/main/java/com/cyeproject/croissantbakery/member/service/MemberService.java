package com.cyeproject.croissantbakery.member.service;

import com.cyeproject.croissantbakery.exception.BusinessLogicException;
import com.cyeproject.croissantbakery.exception.ExceptionCode;
import com.cyeproject.croissantbakery.member.entity.Member;
import com.cyeproject.croissantbakery.member.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberService(MemberRepository memberRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.memberRepository=memberRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    //1. 회원가입 O
    public String createdMember(Member member){
        verifyUsername(member.getUsername());
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setMemberStatus(Member.MemberStatus.MEMBER_JOIN);
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
        return "joined success";
    }

    //2. 회원 로그인 X
    //-> 상태를 login으로 변경합니다
    public String changeStateToLoginMember(Member temp){
        Member member = findVerifiedMember(temp.getUsername());
        /*
        if(member.getPassword().equals(temp.getPassword())){
            if(member.getMemberStatus().equals(Member.MemberStatus.MEMBER_LOGIN)){
                return "already login";
            }
            member.setMemberStatus(Member.MemberStatus.MEMBER_LOGIN);
            return memberRepository.save(member).getMemberStatus().getStatus();
        }
        else
            return "Check the PW";
         */
        if(member.getMemberStatus().equals(Member.MemberStatus.MEMBER_LOGIN)){
            return "already login";
        }
        member.setMemberStatus(Member.MemberStatus.MEMBER_LOGIN);
        return memberRepository.save(member).getMemberStatus().getStatus();
    }

    //3. 회원정보 수정 - 하는중 X
    public Member updateMember(Member temp){
        Member member = findVerifiedMember(temp.getUsername());
        if(!member.getMemberStatus().equals("login")){
            //throw new BusinessLogicException(Ex)
        }
        //정보수정
        return member;
    }

    //4. 회원 로그아웃 O
    //-> 상태를 변경합니다 (logout으로)
    public String logoutMember(String username){
        Member result=findVerifiedMember(username);
        if(result.getMemberStatus().equals(Member.MemberStatus.MEMBER_LOGIN)){
            result.setMemberStatus(Member.MemberStatus.MEMBER_LOGOUT);
        }
        return memberRepository.save(result).getMemberStatus().getStatus();
    }

    //존재하는 회원인지 확인합니다
    public Member findVerifiedMember(String username){
        Optional<Member> member = memberRepository.findByUsername(username);
        Member result =member.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.NOT_FOUND));
        return result;
    }

    //이메일 중복체크를 진행합니다
    private void verifyUsername(String username){
        Optional<Member> member=memberRepository.findByUsername(username);
        if(member.isPresent())
            throw new BusinessLogicException(ExceptionCode.ALREADY_EXISTS);
    }
}
