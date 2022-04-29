package com.portfolio.MyPortfolio8.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    
    @Id
    private String name_skill;
    
    private int skill_progress;

    public Skills() {
    }

    public Skills(String name_skill, int skill_progress) {
        this.name_skill = name_skill;
        this.skill_progress = skill_progress;
    }
    
}
