package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.model.Experience;
import java.util.List;

public interface IExperienceService {
    
    public void createExperience(Experience exp);
    public List<Experience> seeListExperience();
    public void deleteExperience(int id);
    public Experience findExperience(int id);
    public Experience editExperience(Experience exp);
    
}
