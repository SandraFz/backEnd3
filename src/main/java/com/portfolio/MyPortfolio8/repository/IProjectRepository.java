package com.portfolio.MyPortfolio8.repository;

import com.portfolio.MyPortfolio8.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {
    
}
