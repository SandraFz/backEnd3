package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.ProjectDTO;
import com.portfolio.MyPortfolio8.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    
    //Recibe un DTO y devuelve una entidad.
    public Project requestProject (ProjectDTO proyDto){
        
        Project project = new Project();
        
        project.setName_project (proyDto.getName_project());
        project.setPrincipal(proyDto.getPrincipal());
        project.setDescription(proyDto.getDescription());
        project.setImg_proy(proyDto.getImg_proy());
        project.setLogo_img(proyDto.getLogo_img());
        project.setLink_project(proyDto.getLink_project());
        //project.setPerson(proyDto.getPerson());
        
        return project;
   
    }
    
    //Recibe una entidad y devuelve un DTO.
    public ProjectDTO responseProject (Project proy) {
        
        ProjectDTO proyDto = new ProjectDTO();
        
        proyDto.setId_project(proy.getId_project());
        proyDto.setName_project(proy.getName_project());
        proyDto.setPrincipal(proy.getPrincipal());
        proyDto.setDescription(proy.getDescription());
        proyDto.setImg_proy(proy.getImg_proy());
        proyDto.setLogo_img(proy.getLogo_img());
        proyDto.setLink_project(proy.getLink_project());
        //proyDto.setPerson(proy.getPerson());
        
        return proyDto;
             
    }
}

