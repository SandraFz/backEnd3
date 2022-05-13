package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Project;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

    @Setter @Getter
    public class PersonDTO {
    
    private Long id_person; 
    private String name;
    private String lastName;
    private int age;
    private String profession;
    private String origin;
    private String presentation;
    private String professional_photo;
    private String email;
    private List<Project> project;
}
