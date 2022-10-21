package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.SkillDTO;
import com.portfolio.MyPortfolio8.service.SkillsService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "*")
public class SkillController {
    
    @Autowired
    public SkillsService skServ;
    
    //Crea un nuevo skill y lo vinvula a la persona cuyo id se recibe por parámetro.
    @PostMapping("/new/{id}")
    public ResponseEntity<SkillDTO> createdSkill (@RequestBody SkillDTO skDto,
                                                    @PathVariable Long id){
        
        SkillDTO newSkDto = skServ.createSkill(skDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSkDto);
    }
    
    //Arroja la lista de habilidades de la persona cuyo id se pasa por parámetro.
    @GetMapping("/list/{id}")
    public ResponseEntity<List<SkillDTO>> listSkill (@PathVariable Long id){
        
        List<SkillDTO> listSkDto = skServ.listSkills(id);
        return ResponseEntity.status(HttpStatus.OK).body(listSkDto);
    }
    
    //Encuentra un skill según su propio id.
    @GetMapping("/find/{id}")
    public ResponseEntity<SkillDTO> findSkill (@PathVariable Long id){
        
        SkillDTO skDto = skServ.findSkill(id);
        return ResponseEntity.status(HttpStatus.OK).body(skDto);
    }
    
    //Elimina una habilidad según su propio id.
    @DeleteMapping("/delete/{idPers}/{idElem}")
    public void deleteSkill (@PathVariable Long idPers, @PathVariable Long idElem){
        
        skServ.deleteSkill(idPers, idElem);
    }
    
    //Edita una habilidad según su propio id.
    @PutMapping("/edit/{id}")
    public ResponseEntity<SkillDTO> editSkill (@PathVariable Long id,
                                                @RequestBody SkillDTO skDto){
        
        SkillDTO editedSkDto = skServ.editSkill(id, skDto);
        return ResponseEntity.status(HttpStatus.OK).body(editedSkDto);
    }
}


