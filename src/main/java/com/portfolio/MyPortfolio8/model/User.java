package com.portfolio.MyPortfolio8.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="")
    private Person persona;
    
}
