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
    
   
    //CREA un nuevo proyecto y lo vincula a la persona del id  que se pasa como parámetro.
    @Override
    public ProjectDTO createProject(ProjectDTO proyDto, Long id) {
        
        Project proy = mapper.requestProject(proyDto);
        Project newProy = proServ.save(proy);
        
        Person pers = persRepo.getById(id);
        pers.getProject().add(newProy);
        persRepo.saveAndFlush(pers);
        
        ProjectDTO newProyDto = mapper.responseProject(newProy);
        
        return newProyDto;
    }
    
    //Arroja la lista de proyectos de la persona cuyo id se pasa por parámetro.
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
       
    //Busca un proyecto por su propio id.
    @Override
    public ProjectDTO findProject(Long id) {
        
        Project proy = proServ.getById(id);
        ProjectDTO proyDto = mapper.responseProject(proy);
        
        return proyDto;
    }
    
    //Elimina un proyecto por su propio id.
    @Override
    public void deleteProject(Long idPers, Long idElem) {
        
        Person pers = persRepo.getById(idPers); 
        List<Project> listProy = pers.getProject();
        Project proy = proServ.getById(idElem);
        listProy.remove(proy);
        persRepo.saveAndFlush(pers);
    }

    //Elimina un proyecto por su propio id.
    /*@Override
    public void deleteProject(Long id) {
        //proServ.deleteById(id);
        
        Project proy = proServ.getById(id);
        Person pers = proy.getPerson();
        
        pers.getProject().remove(proy);
        proServ.deleteById(id);
        
        persRepo.saveAndFlush(pers);
    }*/
        
    //Edita un proyecto.
    @Override
    public ProjectDTO editProject(Long id, ProjectDTO proyDto) {
        
        Project project = proServ.getById(id);
        
        project.setName_project (proyDto.getName_project());
        project.setDescription(proyDto.getDescription());
        project.setLogo_img(proyDto.getLogo_img());
        project.setLink_project(proyDto.getLink_project());
        project.setPerson(proyDto.getPerson());
        
        Project editedProy = proServ.saveAndFlush(project);
        ProjectDTO editedProyDto = mapper.responseProject(editedProy);
        
        return editedProyDto;
    }
}


