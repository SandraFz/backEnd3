package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.PersonDTO;
import com.portfolio.MyPortfolio8.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
    
    //Recibe el DTO y lo convierte a Entity.
    public Person requestPerson (PersonDTO persDto){
        
        Person person = new Person();
        
        person.setName(persDto.getName());
        person.setLastName(persDto.getLastName());
        person.setAge(persDto.getAge());
        person.setProfession(persDto.getProfession());
        person.setOrigin(persDto.getOrigin());
        person.setPresentation(persDto.getPresentation());
        person.setProfessional_photo(persDto.getProfessional_photo());
        person.setEmail(persDto.getEmail());
        person.setProject(persDto.getProject());
        person.setExperience(persDto.getExperience());
        person.setStudy(persDto.getStudies());
        person.setSkills(persDto.getSkills());
        person.setSoc_med(persDto.getSocMed());
        
        return person;
    }
    
    //Recibe una Entity y la convierte a DTO.
    public PersonDTO responsePerson (Person pers) {
        
        PersonDTO persDto = new PersonDTO();
        
        persDto.setId_person(pers.getId_person());
        persDto.setName(pers.getName());
        persDto.setLastName(pers.getLastName());
        persDto.setAge(pers.getAge());
        persDto.setProfession(pers.getProfession());
        persDto.setOrigin(pers.getOrigin());
        persDto.setPresentation(pers.getPresentation());
        persDto.setProfessional_photo(pers.getProfessional_photo());
        persDto.setEmail(pers.getEmail());
        persDto.setProject(pers.getProject());
        persDto.setExperience(pers.getExperience());
        persDto.setStudies(pers.getStudy());
        persDto.setSkills(pers.getSkills());
        persDto.setSocMed(pers.getSoc_med());
        
        
        return persDto;
        
    }
}



