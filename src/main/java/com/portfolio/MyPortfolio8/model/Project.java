package com.portfolio.MyPortfolio8.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="project")
//@JsonIdentityInfo(
//	generator = ObjectIdGenerators.PropertyGenerator.class, 
//	property = "id")
public class Project {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_project;
    @Column(name="project")
    private String name_project;
    @Column(name="proy_descrip")
    private String description; 
    @Column(name="logo_proy")
    private String logo_img;
    @Column(name="link_proy")
    private String link_project;
    
    //@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "person_id"/*, referencedColumnName="person_id", foreignKey = @ForeignKey(name = "fk_person_project")*/)//@JsonBackReference
    private Person person;

   
    public Person getPerson() {
        return person;
    }

    public Project() {
    }

    public Project(Long id_project, String name_project, String description, String logo_img, String link_project, Person person) {
        this.id_project = id_project;
        this.name_project = name_project;
        this.description = description;
        this.logo_img = logo_img;
        this.link_project = link_project;
        this.person = person;
    }

    //@JsonProperty
    //public Long getParentId() {
    //return person == null ? null : person.getId_person();
//}

   
    
}
