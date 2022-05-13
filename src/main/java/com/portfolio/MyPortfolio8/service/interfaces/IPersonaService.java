package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.PersonFullDTO;
import com.portfolio.MyPortfolio8.dto.PersonDTO;
import com.portfolio.MyPortfolio8.model.Person;
import java.util.List;

public interface IPersonaService {
    
    public PersonDTO createPerson(PersonDTO pers);
    public List<PersonDTO> listPerson();
    public void deletePerson(Long id);
    public PersonDTO findPerson(Long id);
    public PersonDTO editPerson(Long id);
    
}
