package com.portfolio.MyPortfolio8.repository;

import com.portfolio.MyPortfolio8.controller.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Long> {
    
}
