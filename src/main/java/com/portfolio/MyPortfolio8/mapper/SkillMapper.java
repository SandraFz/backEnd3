package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.SkillDTO;
import com.portfolio.MyPortfolio8.model.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    public Skill requestSkill (SkillDTO skDto){
        
        Skill skill = new Skill();
        
        skill.setId(skDto.getId());
        skill.setName_skill(skDto.getName_skill());
        skill.setSkill_progress(skDto.getSkill_progress());
        skill.setPerson(skDto.getPerson());
        
        return skill;
    }
    
    public SkillDTO responseSkill (Skill skill){
        
        SkillDTO skDto = new SkillDTO();
        
        skDto.setId(skill.getId());
        skDto.setName_skill(skill.getName_skill());
        skDto.setSkill_progress(skill.getSkill_progress());
        skDto.setPerson(skill.getPerson());
        
        return skDto;
    }
}


