package com.estsoft.spring_project.crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.estsoft.spring_project.crud.repository.Member;
import com.estsoft.spring_project.crud.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // getMemberAll 멤버 정보를 모두 조회
    public List<Member> getMemberAll() {
        return memberRepository.findAll();
    }

    // member 테이블에 insert 쿼리
    public Member insertMember(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    // member 테이블에 아이디 단건 조회
    public Member selectMemberById(Long id) {
        Optional <Member> optMember = memberRepository.findById(id);
        return optMember.orElseGet(Member::new);
    }

    //member 테이블에 아이디 삭제
    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }

    public List<Member> selectMemberByName(String name) {
        return memberRepository.findByNameContaining(name);
    }
}
