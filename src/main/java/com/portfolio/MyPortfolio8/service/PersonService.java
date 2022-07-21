package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.PersonDTO;
import com.portfolio.MyPortfolio8.mapper.PersonaMapper;
import com.portfolio.MyPortfolio8.service.interfaces.IPersonaService;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.repository.IPersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(persDto);
        return persDto;
    }

    //Recibe un DTO, se setean sus propiedades a la entidad correspondiente según el id y guarda los cambios.
    @Override
    public void editPerson (Long id, PersonDTO persDto){
        
        Person person = persoRepo.getById(id);
        
        person.setName(persDto.getName());
        person.setLastName(persDto.getLastName());
        person.setAge(persDto.getAge());
        person.setProfession(persDto.getProfession());
        person.setOrigin(persDto.getOrigin());
        person.setPresentation(persDto.getPresentation());
        person.setProfessional_photo(persDto.getProfessional_photo());
        person.setEmail(persDto.getEmail());
        
        Person editedPers = persoRepo.saveAndFlush(person);
    }
}
    

        

