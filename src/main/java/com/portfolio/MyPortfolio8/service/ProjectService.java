package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.ProjectDTO;
import com.portfolio.MyPortfolio8.mapper.PersonaMapper;
import com.portfolio.MyPortfolio8.mapper.ProjectMapper;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.Project;
import com.portfolio.MyPortfolio8.repository.IPersonRepository;
import com.portfolio.MyPortfolio8.repository.IProjectRepository;
import com.portfolio.MyPortfolio8.service.interfaces.IProjectService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {
    
    @Autowired
    public IProjectRepository proServ;
    
    @Autowired
    public ProjectMapper mapper;
    
    @Autowired
    public PersonaMapper mapperPer;
    
    @Autowired 
    IPersonRepository persRepo;
    
   
    //CREA un nuevo proyecto y lo vincula al id que se pasa como parámetro
    @Override
    public ProjectDTO createProject(ProjectDTO proyDto, Long id) {
        
        Project proy = mapper.requestProject(proyDto);
        Project newProy = proServ.save(proy);
        
       // Person pers = persRepo.findAll().get(0);
        Person pers = persRepo.getById(id);
        pers.getProject().add(newProy);
        persRepo.saveAndFlush(pers);
        
        ProjectDTO newProyDto = mapper.responseProject(newProy);
        
        return newProyDto;
    }
    
    @Override
    public List<ProjectDTO> listProject(Long id) {
       
        Person pers = persRepo.getById(id);
        List<Project> listProy = (List) pers.getProject();
        
        List<ProjectDTO> listProyDto = new ArrayList();
        
        for(Project proy: listProy){
            
        ProjectDTO proyDto = mapper.responseProject(proy);
        listProyDto.add(proyDto);
        
        }
         return listProyDto;
    }
       
    @Override
    public ProjectDTO findProject(Long id) {
        
        Project proy = proServ.getById(id);
        ProjectDTO proyDto = mapper.responseProject(proy);
        
        return proyDto;
    }

    @Override
    public void deleteProject(Long id) {
        proServ.deleteById(id);
    }

    @Override
    public ProjectDTO editProject(Long id) {
        
        Project proy = proServ.getById(id);
        Project editedProyDto = proServ.saveAndFlush(proy);
        ProjectDTO proyDto = mapper.responseProject(editedProyDto);
        
        return proyDto;
    }

}
