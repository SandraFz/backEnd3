package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.model.Experience;
import java.util.List;

public interface IExperienceService {
    
    public void createExperience(Experience exp);
    public List<Experience> seeListExperience();
    public void deleteExperience(Long id);
    public Experience findExperience(Long id);
    public Experience editExperience(Experience exp);
    
}
