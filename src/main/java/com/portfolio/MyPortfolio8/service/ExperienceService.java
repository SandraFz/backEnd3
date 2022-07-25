package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.ExperienceDTO;
import com.portfolio.MyPortfolio8.mapper.ExperienceMapper;
import com.portfolio.MyPortfolio8.service.interfaces.IExperienceService;
import com.portfolio.MyPortfolio8.model.Experience;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.repository.IExperienceRepository;
import com.portfolio.MyPortfolio8.repository.IPersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    public IExperienceRepository expRepo;
    
    @Autowired
    public ExperienceMapper mapper;
    
    @Autowired
    public IPersonRepository persoRepo;
    
    //Crea una nueva experiencia y lo vincula a la persona cuyo id se pasa por parámetro.
    @Override
    public ExperienceDTO createExperience(ExperienceDTO expDto, Long id) {
    
        Experience exp = mapper.requestExperience(expDto);
        Experience newExp = expRepo.save(exp);
        
        Person pers = persoRepo.getById(id);
        pers.getExperience().add(newExp);
        persoRepo.saveAndFlush(pers);
        
        ExperienceDTO newExpDto = mapper.responseExperience(newExp);
        
        return newExpDto;
    }

    //Arroja una lista de experiencias de la persona cuyo id se recibe por parámetro.
    @Override
    public List<ExperienceDTO> listExperience(Long id) {
        
        Person pers = persoRepo.getById(id);
        List <Experience> listExp = (List) pers.getExperience();
        
        List<ExperienceDTO> listExpDto = new ArrayList();
        
        for (Experience exp: listExp){
            
            ExperienceDTO expDto = mapper.responseExperience(exp);
            listExpDto.add(expDto);
        }
       return listExpDto;
    }
    
    //Busca una experiencia por su propio id.
    @Override
    public ExperienceDTO findExperience(Long id) {
        
        Experience exp = expRepo.getById(id);
        ExperienceDTO expDto = mapper.responseExperience(exp);
        
        return expDto;
    }

    //Eliminar experiencia por su id.
    @Override
    public void deleteExperience(Long idPers, Long idElem) {
        
        Person pers = persoRepo.getById(idPers);
        List<Experience> listExperience = pers.getExperience();
        Experience experience = expRepo.getById(idElem);
        listExperience.remove(experience);
        persoRepo.saveAndFlush(pers);
    }
    
    //Edita una experiencia y la devuelve convertida en DTO.
    @Override
    public ExperienceDTO editExperience(Long id, ExperienceDTO expDto) {
        
        Experience exp = expRepo.getById(id);
        
        exp.setId(expDto.getId());
        exp.setCompany(expDto.getCompany());
        exp.setAsignamet(expDto.getAsignament());
        exp.setAnio_salida(expDto.getAnio_salida());
        exp.setDuracion(expDto.getDuracion());
        exp.setLogo_experience(expDto.getLogo_experience());
        exp.setLink_experience(expDto.getLink_experience());
        exp.setPerson(expDto.getPerson());
        exp.setImgExperience(expDto.getImages());
        
        Experience editedExp = expRepo.saveAndFlush(exp);
        ExperienceDTO editedExpDto = mapper.responseExperience(editedExp);
        
        return editedExpDto;
    }
}


