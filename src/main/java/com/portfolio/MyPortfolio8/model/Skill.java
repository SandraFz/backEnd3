package com.portfolio.MyPortfolio8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    private Long id;
    @Column(name="skill")
    private String name_skill;
    @Column(name="sk_progress")
    private int skill_progress;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person")
    private Person person;

    public Skill() {
    }

    public Skill(Long id, String name_skill, int skill_progress, Person person) {
        this.id = id;
        this.name_skill = name_skill;
        this.skill_progress = skill_progress;
        this.person = person; 
    }

    
    
}
