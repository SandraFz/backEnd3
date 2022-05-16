package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.ExperienceDTO;
import com.portfolio.MyPortfolio8.model.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper {
    
    //Recibe un DTO y devuelve una entidad.
    public Experience requestExperience (ExperienceDTO expDto){
        
        Experience exp = new Experience();
        
        exp.setId(expDto.getId());
        exp.setCompany(expDto.getCompany());
        exp.setAsignamet(expDto.getAsignamet());
        exp.setAnio_salida(expDto.getAnio_salida());
        exp.setDuracion(expDto.getDuracion());
        exp.setLogo_experience(expDto.getLogo_experience());
        exp.setLink_experience(expDto.getLink_experience());
        exp.setPerson(expDto.getPerson());
        
        return exp;
    }
    
    //Recibe una entidad y devuelve un DTO.
    public ExperienceDTO responseExperience(Experience exp){
        
        ExperienceDTO expDto = new ExperienceDTO();
        
        expDto.setId(exp.getId());
        expDto.setCompany(exp.getCompany());
        expDto.setAsignamet(exp.getAsignamet());
        expDto.setAnio_salida(exp.getAnio_salida());
        expDto.setDuracion(exp.getDuracion());
        expDto.setLogo_experience(exp.getLogo_experience());
        expDto.setLink_experience(exp.getLink_experience());
        expDto.setPerson(exp.getPerson());
        
        return expDto;
    }
}
