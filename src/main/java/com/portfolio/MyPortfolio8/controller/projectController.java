package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.ProjectDTO;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.Project;
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
@CrossOrigin
@RequestMapping("/project")
public class projectController {
    
    @Autowired
    private IProjectService proyServ;
    
    @PostMapping("/create/{id}")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO proyDto, @PathVariable Long id){
        
        //ProjectDTO newProyDto = proyServ.createProject(proyDto);
        ProjectDTO newProyDto = proyServ.createProject(proyDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProyDto);
    }
    
    @GetMapping("/list/{id}")
    @ResponseBody
    public ResponseEntity<List<ProjectDTO>> listProject(@PathVariable Long id){
         
        List<ProjectDTO> listProyDto = proyServ.listProject(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(listProyDto);   
    }
    
    @GetMapping("find/{id}")
    public ResponseEntity<ProjectDTO> findProject(@PathVariable Long id){
        
        ProjectDTO proyDto = proyServ.findProject(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(proyDto);
    }
    
    @DeleteMapping("delete/{id}")
    public void deleteProject (@PathVariable Long id){
        proyServ.deleteProject(id);
    }
    
    @PutMapping("edit/{id}")
    public ResponseEntity<ProjectDTO> editProject(@PathVariable Long id){
        
        ProjectDTO editedProyDto = proyServ.editProject(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(editedProyDto);
    }
    
}

