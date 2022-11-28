package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienceDTO {
    
    private Long id;
    private String company;
    private String asignament;
    private int anio_salida;
    private int duracion;
    private String logo_experience;
    private String link_experience;
    private Person person;
}
