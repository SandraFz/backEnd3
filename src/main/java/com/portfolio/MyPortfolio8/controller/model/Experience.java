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
@Table(name="experience")
public class Experience {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String empresa;
    private String funciones;
    private int anio_salida;
    private int duracion;
    private String logo_experience;
    private String link_experience;

    public Experience() {
    }

    public Experience(int id, String empresa, String funciones, int anio_salida, int duracion, String logo_experience, String link_experience) {
        this.id = id;
        this.empresa = empresa;
        this.funciones = funciones;
        this.anio_salida = anio_salida;
        this.duracion = duracion;
        this.logo_experience = logo_experience;
        this.link_experience = link_experience;
    }
    
    
    
}
