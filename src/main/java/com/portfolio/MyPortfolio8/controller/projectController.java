package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.ProjectDTO;
import com.portfolio.MyPortfolio8.service.interfaces.IProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-argentina-prog-f5593.web.app/admin")
@RequestMapping("/project")
public class projectController {
    
    @Autowired
    private IProjectService proyServ;
    
    //Crea un proyecto vinculado a la persona cuyo id se pasa por parámetro.
    @PostMapping("/new/{id}")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO proyDto, @PathVariable Long id){
        
        ProjectDTO newProyDto = proyServ.createProject(proyDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProyDto);
    }
    
    //Arroja una lista de proyectos de la persona cuyp id se pasa por parámetro.
    @GetMapping("/list/{id}")
    public ResponseEntity<List<ProjectDTO>> listProject(@PathVariable Long id){
         
        List<ProjectDTO> listProyDto = proyServ.listProject(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(listProyDto);   
    }
    
    //Encuentra un projecto según su propio id.
    @GetMapping("find/{id}")
    public ResponseEntity<ProjectDTO> findProject(@PathVariable Long id){
        
        ProjectDTO proyDto = proyServ.findProject(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(proyDto);
    }
    
    //Elimina un proyecto según su propio id.
    @DeleteMapping("delete/{idPers}/{idElem}")
    public void deleteProject (@PathVariable Long idPers, @PathVariable Long idElem){
        proyServ.deleteProject(idPers, idElem);
    }
    
    //Edita un proyecto su propio id.
    @PutMapping("edit/{id}")
    public ResponseEntity<ProjectDTO> editProject(@PathVariable Long id, @RequestBody ProjectDTO proyDto){
        
        ProjectDTO editedProyDto = proyServ.editProject(id, proyDto);
        
        return ResponseEntity.status(HttpStatus.OK).body(editedProyDto);
    }
    
}

