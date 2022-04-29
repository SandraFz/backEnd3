package com.portfolio.MyPortfolio8.repository;

import com.portfolio.MyPortfolio8.model.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocMedRepository extends JpaRepository<SocialMedia, Long> {
    
}
