package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.ProjectDTO;
import java.util.List;

public interface IProjectService {
    
    public ProjectDTO createProject(ProjectDTO proy, Long id);
    public List<ProjectDTO> listProject(Long id);
    public ProjectDTO findProject(Long id);
    public void deleteProject(Long id);
    public ProjectDTO editProject(Long id, ProjectDTO proyDto);
}
 