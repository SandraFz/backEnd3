package com.portfolio.MyPortfolio8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="social_media")
public class SocialMedia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="name_SM")
    private String name_SM;
    @Column(name="logo_SM")
    private String logo_SM;
    @Column(name="link_SM")
    private String link_SM;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person")
    private Person person;

    public SocialMedia() {
    }

    public SocialMedia(String name_SM, String logo_SM, String link_SM, Person person) {
        this.name_SM = name_SM;
        this.logo_SM = logo_SM;
        this.link_SM = link_SM;
        this.person = person;
    }
    
    
    
}
