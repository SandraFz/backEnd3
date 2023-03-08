package com.portfolio.MyPortfolio8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="skills")
public class Skill {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="skill")
    private String name_skill;
    @Column(name="sk_progress")
    private int skill_progress;

    @JsonIgnore
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
