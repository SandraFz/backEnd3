package com.portfolio.MyPortfolio8.controller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="project")
public class Project {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name_project;
    private String description;
    private String logo_img;
    private String link_project;

    public Project() {
    }

    public Project(Long id, String name_project, String description, String logo_img, String link_project) {
        this.id = id;
        this.name_project = name_project;
        this.description = description;
        this.logo_img = logo_img;
        this.link_project = link_project;
    }
    
}
