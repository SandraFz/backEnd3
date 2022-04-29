package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.model.Skills;
import java.util.List;


public interface ISkillsService {
    
    public void createSkill(Skills ski);
    public List<Skills> seeListSkills();
    public Skills findSkill(String id);
    public void deleteSkill(String id);
    public Skills editSkill(Skills ski);
}
