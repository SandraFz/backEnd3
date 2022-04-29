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
@Table(name="persona")
public class Person {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String lastName;
    private String origin;
    private String presentation;
    
    private String professional_photo;
    private String email;

    public Person() {
    }

    public Person(Long id, String name, String lastName, String origin, String presentation, String professional_photo, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.origin = origin;
        this.presentation = presentation;
        this.professional_photo = professional_photo;
        this.email = email;
    }
    
}
