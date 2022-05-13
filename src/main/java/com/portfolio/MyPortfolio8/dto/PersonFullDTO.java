package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Person;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonFullDTO implements Serializable{
    
   // private Person pers;
    private Long id;
    
    /*private String name;
    private String lastName;
    private String origin;*/
  //  private String presentation;
    
   // private String professional_photo;
   // private String email;
    
    private List<String> listProject;
   // private String description;
   // private String logo_img;
   // private String link_project;
}


