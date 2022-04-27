package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.controller.model.Person;
import java.util.List;

public interface IPersonaService {
    
    public void createPerson(Person pers);
    public List<Person> seeListPerson();
    public void deletePerson(Long id);
    public Person findPerson(Long id);
  
    
}
