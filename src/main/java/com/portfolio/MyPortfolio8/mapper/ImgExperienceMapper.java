package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.ImgExperienceDTO;
import com.portfolio.MyPortfolio8.model.ImgExperience;
import org.springframework.stereotype.Component;

@Component
public class ImgExperienceMapper {
    
    public ImgExperience requestImgExperience(ImgExperienceDTO imgExpDto){
        
        ImgExperience img = new ImgExperience();
                
        img.setId(imgExpDto.getId());
        img.setImgLink(imgExpDto.getImgLink());
        img.setSoftSkill(imgExpDto.getSoftSkill());
        img.setExperience(imgExpDto.getExperience());
        
        return img;
    }
    
    public ImgExperienceDTO responseImgExperience(ImgExperience imgExp){
        
        ImgExperienceDTO imgDto = new ImgExperienceDTO();
        
        imgDto.setId(imgExp.getId());
        imgDto.setImgLink(imgExp.getImgLink());
        imgDto.setSoftSkill(imgExp.getSoftSkill());
        imgDto.setExperience(imgExp.getExperience());
        
        return imgDto;
    }
    
}
