package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillDTO {
    
    private Long id;
    private String name_skill;
    private int skill_progress;
    private Person person;
}
