package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.ProjectDTO;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.Project;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    
    public Project requestProject (ProjectDTO proyDto){
        
        Project project = new Project();
        
        project.setName_project (proyDto.getName_project());
        project.setDescription(proyDto.getDescription());
        project.setLogo_img(proyDto.getLogo_img());
        project.setLink_project(proyDto.getLink_project());
        project.setPerson(proyDto.getPerson());
        
        return project;
   
    }
    
    public ProjectDTO responseProject (Project proy) {
        
        ProjectDTO proyDto = new ProjectDTO();
        
        proyDto.setId_project(proy.getId_project());
        proyDto.setName_project(proy.getName_project());
        proyDto.setDescription(proy.getDescription());
        proyDto.setLogo_img(proy.getLogo_img());
        proyDto.setLink_project(proy.getLink_project());
        proyDto.setPerson(proy.getPerson());
        
        return proyDto;
 
    }
    
    public List<ProjectDTO> ResponselistProject(Project proy) {
        
        
        List<ProjectDTO> listProyDto = new ArrayList<>();
         
        for(int i = 0; i == 3; i++)
        
{       ProjectDTO proyDto = new ProjectDTO();
        Person person = new Person();

        proyDto.setId_project(proy.getId_project());
        proyDto.setName_project(proy.getName_project());
        proyDto.setDescription(proy.getDescription());
        proyDto.setLogo_img(proy.getLogo_img());
        proyDto.setLink_project(proy.getLink_project());
        proyDto.setPerson(proy.getPerson());
        
        listProyDto.add(proyDto);
}
        return listProyDto;
             
    }
}

