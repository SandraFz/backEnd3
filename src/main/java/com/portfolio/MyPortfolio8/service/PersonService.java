package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.PersonDTO;
import com.portfolio.MyPortfolio8.dto.ProjectDTO;
import com.portfolio.MyPortfolio8.mapper.PersonaMapper;
import com.portfolio.MyPortfolio8.service.interfaces.IPersonaService;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.Project;
import com.portfolio.MyPortfolio8.repository.IPersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonaService {
    
    @Autowired
    public IPersonRepository persoRepo;
    
    @Autowired
    public PersonaMapper mapper;
   
    //Recibe un DTO, crea una nueva Persona y la devuelve en forma de DTO.
    @Override
    public PersonDTO createPerson(PersonDTO persDto) {
       
       Person persona = mapper.requestPerson(persDto);
       Person newPerson = persoRepo.save(persona);
       PersonDTO newPersDto = mapper.responsePerson(newPerson);
        
       return  newPersDto;
    }
    
    //Genera una lista de personas, convierte a cada elemento en DTO y lo devuelve en forma de lista<DTO>.
    @Override
    public List<PersonDTO> listPerson() {
        
       List<Person> listPers = persoRepo.findAll();
       List<PersonDTO> listPersDto = new ArrayList();
            for (Person pers : listPers) {
                PersonDTO persDto = mapper.responsePerson(pers);
                listPersDto.add(persDto);
            }                    
         return listPersDto;
     }

    //Recibe un id y elimina a la persona correspondiente de la BD.
    @Override
    public void deletePerson(Long id) {
        persoRepo.deleteById(id);
    }

    //Recibe un id, encuentra a la persona correspondiente y la devuelve como DTO.
    @Override
    public PersonDTO findPerson(Long id) {
        Person pers = persoRepo.findById(id).orElse(null);
        PersonDTO persDto = mapper.responsePerson(pers);
        return persDto;
    }

    //Recibe un DTO, la convierte en Entity, guarda el cambio y la devuelve como DTO.
    @Override
    public PersonDTO editPerson (Long id, PersonDTO persDto){
        
        
        Person pers = persoRepo.getById(id);
        Person toEditPers = mapper.requestPerson(persDto);
        Person updatePers = persoRepo.save(toEditPers);
        PersonDTO updatePersDto = mapper.responsePerson(updatePers);
        
        return updatePersDto;
        
        
       /*
         Person pers = persoRepo.getById(id);
        Person editedPers = mapper.requestPerson(persDto);
        
        PersonDTO editedPersDto = mapper.responsePerson(editedPers);
        
        return editedPersDto;
        */
        
       
        /*
       Person pers = persoRepo.getById(id); 
        Person editedPers = persoRepo.save(pers);
        PersonDTO editedPersDto = mapper.responsePerson(editedPers);
     
        return editedPersDto;
       */
        
        
    }
}
    

        

