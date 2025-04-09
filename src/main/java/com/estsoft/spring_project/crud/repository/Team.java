package com.estsoft.spring_project.crud.repository;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Team {
    @Id
    @Column(name = "team_id", updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> mebers = new ArrayList<>();
}
