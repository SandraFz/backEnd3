package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.model.Skill;
import java.util.List;


public interface ISkillsService {
    
    public void createSkill(Skill ski);
    public List<Skill> seeListSkills();
    public Skill findSkill(Long id);
    public void deleteSkill(Long id);
    public Skill editSkill(Skill ski);
}
