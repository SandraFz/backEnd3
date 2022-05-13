package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.model.Skill;
import com.portfolio.MyPortfolio8.repository.ISkillsRepository;
import com.portfolio.MyPortfolio8.service.interfaces.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements ISkillsService {
    
    @Autowired
    public ISkillsRepository skiServ;

    @Override
    public void createSkill(Skill ski) {
        skiServ.save(ski);
    }

    @Override
    public List<Skill> seeListSkills() {
        return skiServ.findAll();
    }

    @Override
    public Skill findSkill(Long id) {
        return skiServ.findById(id).orElse(null);
    }

    @Override
    public void deleteSkill(Long id) {
        skiServ.deleteById(id);
    }

    @Override
    public Skill editSkill(Skill ski) {
        return skiServ.saveAndFlush(ski);
    }
}
