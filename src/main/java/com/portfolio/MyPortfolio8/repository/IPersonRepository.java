package com.portfolio.MyPortfolio8.repository;

import com.portfolio.MyPortfolio8.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

    
}
