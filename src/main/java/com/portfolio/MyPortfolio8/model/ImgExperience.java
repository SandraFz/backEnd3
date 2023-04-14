package com.portfolio.MyPortfolio8.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name="imgExperience")
public class ImgExperience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_img;
  
    @Column(name = "imgLink")
    private String imgLink;
    
    @Column(name = "softSkill")
    private String softSkill;

    /*Agregrué todo después de LAZY*/
    @ManyToOne(fetch=FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "experience")
    private Experience experience;

    public ImgExperience() {
    }

    public ImgExperience(Long id_img, String imgLink, String softSkill, Experience experience) {
        this.id_img = id_img;
        this.imgLink = imgLink;
        this.softSkill = softSkill;
        this.experience = experience;
    }

    
   
    
    
}
