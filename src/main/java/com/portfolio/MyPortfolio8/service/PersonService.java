package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonaService {
    
    @Autowired
    public IPersonRepository persoRepo;

    @Override
    public List<Person> seeListPerson() {
        return persoRepo.findAll();
    }
    
    @Override
    public void createPerson(Person pers) {
        persoRepo.save(pers);
    }

    @Override
    public void deletePerson(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
       return persoRepo.findById(id).orElse(null);
    }

    @Override
    public Person editPerson(Person pers) {
       return persoRepo.saveAndFlush(pers);
    }

    
}
    
    
        

