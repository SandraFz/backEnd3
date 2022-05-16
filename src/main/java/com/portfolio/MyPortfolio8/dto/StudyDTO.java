package com.portfolio.MyPortfolio8.dto;

import com.portfolio.MyPortfolio8.model.Person;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class StudyDTO {
    
    private Long id;
    private String insti_studios;
    private String title_studies;
    private int anio_iniStudy;
    private int anio_end;
    private String logo_studies;
    private String link_studies;
    private Person person;
}
