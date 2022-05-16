package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SocialMediaDTO {
    
    private Long id;
    private String name_SM;
    private String logo_SM;
    private String link_SM;
    private Person person;
}
