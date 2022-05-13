package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.PersonFullDTO;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.Project;
import com.portfolio.MyPortfolio8.service.PersonService;
import com.portfolio.MyPortfolio8.service.ProjectService;
import com.portfolio.MyPortfolio8.service.interfaces.IPersonaService;
import com.portfolio.MyPortfolio8.service.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullPersonController {
    
    //@Autowired
    //private PersonFullDTO full;
    
   /* @Autowired
    private IPersonaService perServ; 
    
    @PostMapping("/create/person")
    public void createPerson(@RequestBody Person pers){
        Project proy = new Project();
        
        PersonFullDTO full = new PersonFullDTO();
        
        
        
        full.setName(pers.getName());
        full.setLastName(pers.getLastName());
        full.setOrigin(pers.getOrigin());
        full.setName_project(proy.getName_project());
        
        perServ.createPerson(pers);
    }
    /*
    
    @GetMapping("/full/{id}")
    @ResponseBody
    public PersonFullDTO fullPers(@PathVariable Long id){
        
        Person pers = new Person();
        Project proy = new Project();
        PersonFullDTO fullPers = new PersonFullDTO();
        
        fullPers.setName(pers.getName());
        fullPers.setLastName(pers.getLastName());
        fullPers.setOrigin(pers.getOrigin());
        fullPers.setName_project(proy.getName_project());
        
        return fullPers;
    }*/
    
    
    
    
    
    
    
}
