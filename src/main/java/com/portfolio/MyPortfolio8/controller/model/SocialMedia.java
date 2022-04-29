package com.portfolio.MyPortfolio8.controller.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class SocialMedia {
    
    @Id
    private String name_SM;
    private String logo_SM;
    private String link_SM;

    public SocialMedia() {
    }

    public SocialMedia(String name_SM, String logo_SM, String link_SM) {
        this.name_SM = name_SM;
        this.logo_SM = logo_SM;
        this.link_SM = link_SM;
    }
    
    
    
}
