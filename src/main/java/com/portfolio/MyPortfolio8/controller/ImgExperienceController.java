package com.portfolio.MyPortfolio8.controller;

import com.portfolio.MyPortfolio8.dto.ImgExperienceDTO;
import com.portfolio.MyPortfolio8.service.ImgExperienceService;
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
@RequestMapping("/exp/img/")
@CrossOrigin(origins = "*")
public class ImgExperienceController {
    
    @Autowired
    public ImgExperienceService imgServ;
    
    //Agrega una nueva imagen y la vincula a la experiencia cuyo id recibe por parámetro.
    @PostMapping("new/{id}")
    public ResponseEntity<ImgExperienceDTO> createImgExperience(
                                            @RequestBody ImgExperienceDTO imgExpDto, 
                                            @PathVariable Long id){
        ImgExperienceDTO newImgExpDto = imgServ.createImgExperience(imgExpDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newImgExpDto);
    }
    
    //Arroja la lista de imágenes de la experiencia cuyo id se pasa por parámetro.
    @GetMapping("list/{id}")
    public ResponseEntity<List<ImgExperienceDTO>> listImgExperience(@PathVariable Long id){
        
        List<ImgExperienceDTO> listImgExpDto = imgServ.listImgExperience(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(listImgExpDto);
    }
    
    //Encuentra una imagen según su propio id.
    @GetMapping("find/{id}")
    public ResponseEntity<ImgExperienceDTO> findImgExperience(@PathVariable Long id){
        
        ImgExperienceDTO imgExpDto = imgServ.findImgExperience(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(imgExpDto);
    }
    
    //Elimina una imagen según su propio id.
    @DeleteMapping("delete/{idExp}/{idImg}")
    public void deleteImgExperience(@PathVariable Long idExp, @PathVariable Long idImg){
    
        imgServ.deleteImgExperience(idExp, idImg);
}
    
    //Edita una imagen según su propio id.
    @PutMapping("edit/{id}")
    public ResponseEntity<ImgExperienceDTO> editImg(@PathVariable Long id, @RequestBody ImgExperienceDTO imgDto) {
        
        ImgExperienceDTO editedImg = imgServ.editImgExperience(id, imgDto);
        
        return ResponseEntity.status(HttpStatus.OK).body(editedImg);
    }
}
    
    
    
 
