package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.ExperienceDTO;
import com.portfolio.MyPortfolio8.model.Experience;
import java.util.List;

public interface IExperienceService {
    
    public ExperienceDTO createExperience(ExperienceDTO expDto, Long id);
    public List<ExperienceDTO> listExperience(Long id);
    public ExperienceDTO findExperience(Long id);
    public void deleteExperience(Long idPers, Long idElem);
    public ExperienceDTO editExperience(Long id, ExperienceDTO expDto);
    
}
