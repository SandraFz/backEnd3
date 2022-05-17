package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.PersonDTO;
import java.util.List;

public interface IPersonaService {
    
    public PersonDTO createPerson(PersonDTO pers);
    public List<PersonDTO> listPerson();
    public PersonDTO findPerson(Long id);
    public void deletePerson(Long id);
    public void editPerson(Long id, PersonDTO persDto);
    
}
