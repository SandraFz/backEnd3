package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.ExperienceDTO;
import com.portfolio.MyPortfolio8.service.ExperienceService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://portfolio-argentina-prog-f5593.web.app")
@RequestMapping("/exp")
public class ExperienceController {
    
    @Autowired
    public ExperienceService expServ;
    
    //Crea una nueva experiencia y la vincula a la persona cuyo id se recibe por parámetro.
    @PostMapping("/new/{id}")
    public ResponseEntity<ExperienceDTO> createExperience(@RequestBody ExperienceDTO expDto,@PathVariable Long id){
        
        ExperienceDTO newExpDto = expServ.createExperience(expDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExpDto);
    }
    
    //Arroja la lista de experiencias de la persona cuyo id se pasa por parámetro.
    @GetMapping("list/{id}")
    public ResponseEntity<List<ExperienceDTO>> listExperience(@PathVariable Long id){
        
        List<ExperienceDTO> listExpDto = expServ.listExperience(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(listExpDto);
    }
    
    //Encuentra una experiencia según su propio id.
    @GetMapping("find/{id}")
    public ResponseEntity<ExperienceDTO> findProject(@PathVariable Long id){
        
        ExperienceDTO expDto = expServ.findExperience(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(expDto);
    }
    
    //Elimina una experiencia según su propio id.
    @DeleteMapping("delete/{idPers}/{idElem}")
    public void deleteExperience (@PathVariable Long idPers, @PathVariable Long idElem){
        expServ.deleteExperience(idPers, idElem);
    }
    
    //Edita una experiencia según su propio id.
    @PutMapping("edit/{id}")
    public ResponseEntity<ExperienceDTO> editExperience(@PathVariable Long id, @RequestBody ExperienceDTO expDto){
        
        ExperienceDTO editedExpDto = expServ.editExperience(id, expDto);
        
        return ResponseEntity.status(HttpStatus.OK).body(editedExpDto);         
    }
    
}
