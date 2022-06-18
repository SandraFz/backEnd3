package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Experience;
import com.portfolio.MyPortfolio8.model.Project;
import com.portfolio.MyPortfolio8.model.Skill;
import com.portfolio.MyPortfolio8.model.SocialMedia;
import com.portfolio.MyPortfolio8.model.Study;
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
    //private byte img;
    //private String email;
    //private List<Project> project;
    //private List<Experience> experience;
    //private List<Study> studies;
    //private List<Skill> skills;
    //private List<SocialMedia> socMed;
}
