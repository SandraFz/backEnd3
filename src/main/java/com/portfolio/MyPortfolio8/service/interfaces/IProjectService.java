package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.PersonFullDTO;
import com.portfolio.MyPortfolio8.dto.ProjectDTO;
import com.portfolio.MyPortfolio8.model.Project;
import java.util.List;

public interface IProjectService {
    
    public ProjectDTO createProject(ProjectDTO proy, Long id);
    public List<ProjectDTO> listProject(Long id);
    public Project findProject(Long id);
    public void deleteProject(Long id);
    public Project editProject(Project pro);
}
