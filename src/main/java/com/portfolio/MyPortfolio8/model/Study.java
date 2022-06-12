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
@Table(name="studies")
public class Study {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="instit")
    private String insti_studios;
    @Column(name="title_studies")
    private String title_studies;
    @Column(name="anio_ini")
    private int anio_iniStudy;
    @Column(name="anio_endStudy")
    private int anio_end;
    @Column(name="logo_studies")
    private String logo_studies;
    @Column(name="link_studies")
    private String link_studies;
    
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="person")
    private Person person;

    public Study() {
    }

    public Study(Long id, String insti_studios, String title_studies, int anio_iniStudy, int anio_end, String logo_studies, String link_studies, Person person) {
        this.id = id;
        this.insti_studios = insti_studios;
        this.title_studies = title_studies;
        this.anio_iniStudy = anio_iniStudy;
        this.anio_end = anio_end;
        this.logo_studies = logo_studies;
        this.link_studies = link_studies;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
    
    
}
