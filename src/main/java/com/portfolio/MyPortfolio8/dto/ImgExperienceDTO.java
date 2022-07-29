package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Experience;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ImgExperienceDTO {
    
    private Long id_img;
    private String imgLink;
    private String softSkill;
    private Experience experience;
}
