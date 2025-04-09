package com.estsoft.spring_project.crud.controller;

import com.estsoft.spring_project.crud.repository.Member;
import com.estsoft.spring_project.crud.repository.MemberRepository;
import com.estsoft.spring_project.crud.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    //테이블 전체 조회
    @ResponseBody
    @GetMapping("/members")
    public List<Member> showMembers() {
        return memberService.getMemberAll();
    }

    //테이블에 데이터 추가
    @ResponseBody
    @PostMapping("/members")
    public Member saveMember(@RequestBody Member member) {
        return memberService.insertMember(member);
    }

    // 단건조회
    @ResponseBody
    @GetMapping("/members/{id}")
    public Member selectMemberById(@PathVariable Long id) {
        //findById(id) select * from member where id = #id
        return memberService.selectMemberById(id);
    }
    // 테이블 데이터 삭제
    @ResponseBody
    @DeleteMapping("/members/{id}")
    public String deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
        return "삭제완료";
    }

    @GetMapping("/search/members")
    @ResponseBody
    // 특정 이름 조회
    public List<Member> selectMemberByName(@RequestParam("name") String name){
        return memberService.selectMemberByName(name);
    }


    @GetMapping("/hi")
    public String htmlPage() {
        return "hi";
    }
}
