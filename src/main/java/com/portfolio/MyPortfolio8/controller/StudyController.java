package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.StudyDTO;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.service.StudiesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studies")
public class StudyController {
    
    @Autowired
    public StudiesService stuServ;
    
    //Crea un nuevo estudio y lo vincula a la persona cuyo id se recibe por parámetro.
    @PostMapping("/new/{id}")
    public ResponseEntity<StudyDTO> createStudy(@RequestBody StudyDTO stuDto,
                                                @PathVariable Long id){
        
        StudyDTO newStuDto = stuServ.createStudy(stuDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStuDto);
    }

    //Arroja la lista de estudios de la persona cuyo id se pasa por parámetro.
    @GetMapping("list/{id}")
    public ResponseEntity<List<StudyDTO>> listStudies (@PathVariable Long id){
        
        List<StudyDTO> listStuDto = stuServ.listStudies(id);
        return ResponseEntity.status(HttpStatus.OK).body(listStuDto);
    }
    
    //Encuentra un estudio según su propio id.
    @GetMapping("/find/{id}")
    public ResponseEntity<StudyDTO> findStudy (@PathVariable Long id){
        
        StudyDTO stuDto = stuServ.findStudy(id);
        return ResponseEntity.status(HttpStatus.OK).body(stuDto);
    }
    
    //Elimina una experiencia según su propio id.
    @DeleteMapping("/delete/{id}")
    public void deleteStudy (@PathVariable Long id){
        
        stuServ.deleteStudy(id);
    }
    
    //Edita una experiencia según su propio id.
    @PutMapping("/edit/{id}")
    public ResponseEntity<StudyDTO> editStudy (@PathVariable Long id,
                                                @RequestBody StudyDTO stuDto){
        
        StudyDTO editedStuDto = stuServ.editStudy(id, stuDto);
        return ResponseEntity.status(HttpStatus.OK).body(editedStuDto);
    }
    
    /*@DeleteMapping("/borrar/{id}")
    public void findOwner(@PathVariable Long id){
        stuServ.findOwner(id);
    }*/
}

