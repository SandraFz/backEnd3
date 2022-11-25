package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.ExperienceDTO;
import com.portfolio.MyPortfolio8.dto.ImgExperienceDTO;
import java.util.List;

public interface IImgExperienceService {
    
    public ImgExperienceDTO createImgExperience(ImgExperienceDTO imgExpDto, Long id);
    public List<ImgExperienceDTO> listImgExperience(Long id);
    public ImgExperienceDTO findImgExperience(Long id);
    public void deleteImgExperience(Long idExp, Long idImg);
    public ImgExperienceDTO editImgExperience(Long id, ImgExperienceDTO imgDto);
}


