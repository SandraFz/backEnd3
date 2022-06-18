package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.SocialMediaDTO;
import com.portfolio.MyPortfolio8.service.SocialMediaService;
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
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/soc_media")
public class SocialMediaController {
    
    @Autowired
    public SocialMediaService sMedServ;
    
    //Crea un nuevo social media y lo vincula a la persona cuyo id se recibe por parámetro.
    @PostMapping("/new/{id}")
    public ResponseEntity<SocialMediaDTO> createSocialMedia (@RequestBody SocialMediaDTO smDto,
                                                                @PathVariable Long id){
        
        SocialMediaDTO newSocMedDto = sMedServ.createSocMedia(smDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSocMedDto);
    }
    
    //Arroja la lista de redes sociales de la persona cuyo id se pasa por parámetro.
    @GetMapping("/list/{id}")
    public ResponseEntity<List<SocialMediaDTO>> listSocMed (@PathVariable Long id){
        
        List<SocialMediaDTO> listSocMedDto = sMedServ.listSocMed(id);
        return ResponseEntity.status(HttpStatus.OK).body(listSocMedDto);
    }
    
    //Encuentra una red social según su propio id.
    @GetMapping("/find/{id}")
    public ResponseEntity<SocialMediaDTO> findSocMed (@PathVariable Long id){
        
        SocialMediaDTO socMedDto = sMedServ.findSocMed(id);
        return ResponseEntity.status(HttpStatus.OK).body(socMedDto);
    }
    
    //Elimina un social media según su propio id.
    @DeleteMapping("/delete/{idPers}/{idElem}")
    public void deleteSocMed (@PathVariable Long idPers, @PathVariable Long idElem){
        
        sMedServ.deleteSocMed(idPers, idElem);
    }
    
    //Edita una red social según su propio id.
    @PutMapping("/edit/{id}")
    public ResponseEntity<SocialMediaDTO> editSocMed (@PathVariable Long id,
                                                        @RequestBody SocialMediaDTO sMedDto){
        
        SocialMediaDTO editedSMedDto = sMedServ.editSocMed(id, sMedDto);
        return ResponseEntity.status(HttpStatus.OK).body(editedSMedDto);
    }
}


