package com.portfolio.MyPortfolio8.repository;

import com.portfolio.MyPortfolio8.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills, Long> {
    
}
