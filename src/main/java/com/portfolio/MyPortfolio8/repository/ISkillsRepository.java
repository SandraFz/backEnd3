package com.portfolio.MyPortfolio8.repository;

import com.portfolio.MyPortfolio8.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skill, Long> {

    
}
