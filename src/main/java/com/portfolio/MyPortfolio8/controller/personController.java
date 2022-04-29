package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.model.Experience;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.service.interfaces.IExperienceService;
import com.portfolio.MyPortfolio8.service.interfaces.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class personController {
    
    @Autowired
    private IExperienceService expServ;
    
    @Autowired
    private IPersonaService persoServ; 
    
//Person
    
    @PostMapping("/create/person")
    public void createPerson(@RequestBody Person pers){
       persoServ.createPerson(pers);
    }
    
    @GetMapping("/list/person")
    @ResponseBody
    public List<Person> seeListPerson(){
        return persoServ.seeListPerson(); 
    }
    
    @DeleteMapping("/delete/person/{id}")
    public void deletePerson(@PathVariable Long id){
        persoServ.deletePerson(id);
    }
    
    @GetMapping("/find/person/{id}")
    @ResponseBody
    public Person findPerson(@PathVariable Long id){
        return persoServ.findPerson(id);
    }
    
    @PutMapping("/edit/person")
    public Person editPerson(@RequestBody Person pers){
        return persoServ.editPerson(pers);
    }
    
//Experience
    @PostMapping("/create/experience")
    public void createExperience(@RequestBody Experience exp){
       expServ.createExperience(exp);
    }
    
    @GetMapping("/list/experience")
    @ResponseBody
    public List<Experience> seeListExperience(){
        return expServ.seeListExperience(); 
    }
    
    @DeleteMapping("/delete/experience/{id}")
    public void deleteExperience(@PathVariable Long id){
        expServ.deleteExperience(id);
    }
    
    @GetMapping("/find/experience/{id}")
    @ResponseBody
    public Experience findxperience(@PathVariable Long id){
        return expServ.findExperience(id);
    }
    
    @PutMapping("/edit/experience")
    public Experience editExperience(@RequestBody Experience exp){
        return expServ.editExperience(exp);
    }
     
}
