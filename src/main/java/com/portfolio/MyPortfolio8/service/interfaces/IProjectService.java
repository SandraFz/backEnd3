package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.model.Project;
import java.util.List;

public interface IProjectService {
    
    public void createProject(Project pro);
    public List<Project> seeListProject();
    public Project findProject(Long id);
    public void deleteProject(Long id);
    public Project editProject(Project pro);
}
