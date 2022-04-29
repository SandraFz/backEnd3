package com.portfolio.MyPortfolio8.repository;

import com.portfolio.MyPortfolio8.model.Studies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudiesRepository extends JpaRepository<Studies, Long>{
    
}
