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
@Table(name="studies")
public class Studies {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String insti_studios;
    private String title_studios;
    private int anio_ini;
    private int anio_end;
    private String logo_studios;
    private String link_studios;

    public Studies() {
    }

    public Studies(int id, String insti_studios, String title_studios, int anio_ini, int anio_end, String logo_studios, String link_studios) {
        this.id = id;
        this.insti_studios = insti_studios;
        this.title_studios = title_studios;
        this.anio_ini = anio_ini;
        this.anio_end = anio_end;
        this.logo_studios = logo_studios;
        this.link_studios = link_studios;
    }
    
    
    
}
