package com.estsoft.spring_project.crud.controller;


import com.estsoft.spring_project.crud.repository.Team;
import lombok.Getter;

@Getter
public class TeamDTO {
    private final Long teamId;
    private final String name;

    public TeamDTO(Team team) {
        teamId = team.getId();
        name = team.getName();
    }
}
