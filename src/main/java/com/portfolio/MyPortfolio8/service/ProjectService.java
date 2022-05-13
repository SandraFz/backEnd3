package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.PersonFullDTO;
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
        
        ProjectDTO newProyDto = mapper.responseProject(newProy);
        
        return newProyDto;
        
    }

    @Override
    public List<ProjectDTO> listProject(Long id) {
        
        List<ProjectDTO> listProyDto = new ArrayList<>();
        persRepo.findById(id);
        
        for(int i = 0; i == 3; i++){       
            
            ProjectDTO proyDto = new ProjectDTO();
        /*    
            Person person = mapperPer.responsePerson(pers);
           

        proyDto.setId_project(proy.getId_project());
        proyDto.setName_project(proy.getName_project());
        proyDto.setDescription(proy.getDescription());
        proyDto.setLogo_img(proy.getLogo_img());
        proyDto.setLink_project(proy.getLink_project());
        proyDto.setPerson(proy.getPerson());
        
        listProyDto.add(proyDto);*/
}
        return listProyDto;
             
    }

    /*
    public static List<ProjectDTO> listProjects(List<Project> Projects){
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for (Author author: authors) {
            authorResponseDtos.add(authorToAuthorResponseDto(author));
        }
        return authorResponseDtos;
    }
    */
    /*
    
    @Override
    public Project findProject(Long id) {
        return proServ.findById(id).orElse(null);
    }

    @Override
    public void deleteProject(Long id) {
        proServ.deleteById(id);
    }

    @Override
    public Project editProject(Project pro) {
        return proServ.saveAndFlush(pro);
    }*/

    @Override
    public Project findProject(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteProject(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Project editProject(Project pro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
