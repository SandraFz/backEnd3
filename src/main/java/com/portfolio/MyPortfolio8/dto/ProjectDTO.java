package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Person;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ProjectDTO {

    private Long id_project;
    private String name_project;
    private String description; 
    private String logo_img;
    private String link_project;
    private Person person;
    
}
