package com.cyeproject.croissantbakery.member.service;

import com.cyeproject.croissantbakery.exception.BusinessLogicException;
import com.cyeproject.croissantbakery.exception.ExceptionCode;
import com.cyeproject.croissantbakery.member.entity.Member;
import com.cyeproject.croissantbakery.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    //1. 회원가입 - 아직 안함
    public void joinMember(Member member){
        
    }

    //2. 회원 로그인
    //-> 상태를 login으로 변경합니다
    public String loginMember(Member temp){
        Member member = findVerifiedMember(temp.getMemberCode());
        if(member.getPassword().equals(temp.getPassword())){
            if(member.getMemberStatus().equals(Member.MemberStatus.MEMBER_LOGIN)){
                return "already login";
            }
            member.setMemberStatus(Member.MemberStatus.MEMBER_LOGIN);
            return memberRepository.save(member).getMemberStatus().getStatus();
        }
        else
            return "Check the PW";
    }

    //3. 회원정보 수정 - 하는중
    public Member updateMember(Member temp){
        Member member = findVerifiedMember(temp.getMemberCode());
        if(member.getMemberStatus().equals("login")){

        }
        return null;
    }

    //4. 회원 로그아웃
    //-> 상태를 변경합니다 (logout으로)
    public String logoutMember(Member member){
        Member result=findVerifiedMember(member.getMemberCode());
        if(result.getMemberStatus().equals(Member.MemberStatus.MEMBER_LOGIN)){
            result.setMemberStatus(Member.MemberStatus.MEMBER_LOGOUT);
        }
        return memberRepository.save(result).getMemberStatus().getStatus();
    }

    //존재하는 회원인지 확인합니다
    private Member findVerifiedMember(String memberCode){
        Optional<Member> member = memberRepository.findById(memberCode);
        Member result =member.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.NOT_FOUND));
        return result;
    }

    //이메일 중복체크를 진행합니다
    private void verifyEmail(String email){
        Optional<Member> member=memberRepository.findByMemberEmail(email);
        if(member.isPresent())
            throw new BusinessLogicException(ExceptionCode.ALREADY_EXISTS);
    }
}
