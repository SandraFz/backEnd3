package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.ExperienceDTO;
import com.portfolio.MyPortfolio8.dto.ImgExperienceDTO;
import com.portfolio.MyPortfolio8.mapper.ImgExperienceMapper;
import com.portfolio.MyPortfolio8.model.Experience;
import com.portfolio.MyPortfolio8.model.ImgExperience;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.repository.IExperienceRepository;
import com.portfolio.MyPortfolio8.repository.IImgExperienceRepository;
import com.portfolio.MyPortfolio8.service.interfaces.IImgExperienceService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgExperienceService implements IImgExperienceService{
    
    @Autowired
    public IImgExperienceRepository imgRepo;
    
    @Autowired
    public ImgExperienceMapper mapper;
    
    @Autowired
    public IExperienceRepository expRepo;
    
    //Agrega una nueva imagen y lo vincula al proyecto cuyo id se pasa por parámetro.
    @Override
    public ImgExperienceDTO createImgExperience(ImgExperienceDTO imgExpDto, Long id) {

        /*ImgExperience imgExp = mapper.requestImgExperience(imgExpDto);

        Experience exp = expRepo.getById(id);
        exp.getImgExperience().add(imgExp);
        ImgExperience newImgExp = imgRepo.save(imgExp);

        expRepo.saveAndFlush(exp);*/


        ImgExperience imgExp = mapper.requestImgExperience(imgExpDto);
        ImgExperience newImgExp = imgRepo.save(imgExp);
        
        Experience exp = expRepo.getById(id);
        exp.getImgExperience().add(newImgExp);
        expRepo.saveAndFlush(exp);
        
        ImgExperienceDTO newImgExpDto = mapper.responseImgExperience(newImgExp);
        
        return newImgExpDto;
    }
    
    //Arroja una lista de imágenes de la experienca cuyo id se recibe por parámetro.
    @Override
    public List<ImgExperienceDTO> listImgExperience(Long id) {
        
        Experience exp = expRepo.getById(id);
        List <ImgExperience> listImgExp = (List) exp.getImgExperience();
        
        List<ImgExperienceDTO> listImgExpDto = new ArrayList();
        
        for (ImgExperience imgExp: listImgExp) {
            
            ImgExperienceDTO imgExpDto = mapper.responseImgExperience(imgExp);
            listImgExpDto.add(imgExpDto);    
        }
        return listImgExpDto;
    }
    
//Busca una imagen por su propio id.
    @Override
    public ImgExperienceDTO findImgExperience(Long id) {
        
        ImgExperience imgExp = imgRepo.getById(id);
        ImgExperienceDTO imgExpDto = mapper.responseImgExperience(imgExp);
        
        return imgExpDto;
    }
    
    //Elimina una imagen por su id.
     @Override
     public void deleteImgExperience(Long idExp, Long idImg) {
         
         Experience exp = expRepo.getById(idExp);
         List<ImgExperience> listImgExp = exp.getImgExperience();
         ImgExperience imgExp = imgRepo.getById(idImg);
         listImgExp.remove(imgExp);
         expRepo.saveAndFlush(exp);
     }
     
     //Edita una imagen y la devuelve convertida en DTO.
     @Override
     public ImgExperienceDTO editImgExperience(Long id, ImgExperienceDTO imgDto) {
         
         ImgExperience img = imgRepo.getById(id);
         
         img.setImgLink(imgDto.getImgLink());
         img.setSoftSkill(imgDto.getSoftSkill());
         
         ImgExperience editedImg = imgRepo.saveAndFlush(img);
         ImgExperienceDTO editedImgDto = mapper.responseImgExperience(editedImg);
         
         return editedImgDto;
     }
     
}

