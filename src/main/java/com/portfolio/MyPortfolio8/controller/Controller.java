package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.controller.model.Person;
import com.portfolio.MyPortfolio8.service.IPersonaService;
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
public class Controller {
    
    @Autowired
    private IPersonaService persoServ; 
    
    /*List<Person> listPerson = new ArrayList();
    
    @GetMapping ("/hola/{name}")
    public String holaMundo(@PathVariable String name) {
        return "Hola, " + name;
    }*/
    
    @GetMapping ("/chau")
    public String chauYou (@RequestParam String name){
        return "Chau, " +name;
    }
    
    @PostMapping("/createPerson")
    public void createPerson(@RequestBody Person pers){
       persoServ.createPerson(pers);
        //listPerson.add(pers);
    }
    
    @GetMapping("/listPerson")
    @ResponseBody
    public List<Person> seeListPerson(){
        return persoServ.seeListPerson(); 
    //return listPerson;
    }
    
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id){
        persoServ.deletePerson(id);
    }
    
    @GetMapping("/find/{id}")
    @ResponseBody
    public Person findPerson(@PathVariable Long id){
        return persoServ.findPerson(id);
    }
    
    @PutMapping("/edit")
    public Person editPerson(@RequestBody Person pers){
        return persoServ.editPerson(pers);
    }
     
}
