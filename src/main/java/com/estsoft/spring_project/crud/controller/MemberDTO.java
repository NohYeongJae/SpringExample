package com.estsoft.spring_project.crud.controller;

import com.estsoft.spring_project.crud.repository.Member;
import lombok.Getter;

@Getter
public class MemberDTO {
    private final Long id;
    private final String name;
    private final TeamDTO teamDTO;

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.teamDTO = new TeamDTO(member.getTeam());
    }
}
