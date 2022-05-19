package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.SkillDTO;
import com.portfolio.MyPortfolio8.model.Skill;
import java.util.List;


public interface ISkillsService {
    
    public SkillDTO createSkill(SkillDTO skiDto, Long id);
    public List<SkillDTO> listSkills(Long id);
    public SkillDTO findSkill(Long id);
    public void deleteSkill(Long id);
    public SkillDTO editSkill(Long id, SkillDTO skiDto);
}
