package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.PersonFullDTO;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.Project;

public class FullPersonMapper {
    
    private PersonaMapper perMapper;
    
    public PersonFullDTO responsetFullPerson (Person pers){
        
       PersonFullDTO persFullDto = new PersonFullDTO();
       
       persFullDto.setId(pers.getId_person());
       //persFullDto.setName_project(pers.getProject());
       
       return persFullDto;
        
        
        
    }
    
    /*
    private Long id_dto;
    
    private String name;
    private String lastName;
    private String origin;
    private String name_project;
    */
}
