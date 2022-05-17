package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.ExperienceDTO;
import com.portfolio.MyPortfolio8.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
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
    
    
    
}
