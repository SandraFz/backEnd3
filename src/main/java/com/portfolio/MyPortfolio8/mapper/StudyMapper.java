 package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.StudyDTO;
import com.portfolio.MyPortfolio8.model.Study;
import org.springframework.stereotype.Component;

@Component
public class StudyMapper {
    
    public Study requestStudy(StudyDTO stuDto){
        
        Study study = new Study();
        
        study.setId(stuDto.getId());
        study.setInsti_studios(stuDto.getInsti_studios());
        study.setTitle_studies(stuDto.getTitle_studies());
        study.setAnio_iniStudy(stuDto.getAnio_iniStudy());
        study.setAnio_end(stuDto.getAnio_end());
        study.setLogo_studies(stuDto.getLogo_studies());
        study.setLink_studies(stuDto.getLink_studies());
        study.setPerson(stuDto.getPerson());
        
        return study;
    }
    
    public StudyDTO responseStudy(Study stu){
        
        StudyDTO stuDto = new StudyDTO();
        
        stuDto.setId(stu.getId());
        stuDto.setInsti_studios(stu.getInsti_studios());
        stuDto.setTitle_studies(stu.getTitle_studies());
        stuDto.setAnio_iniStudy(stu.getAnio_iniStudy());
        stuDto.setAnio_end(stu.getAnio_end());
        stuDto.setLogo_studies(stu.getLogo_studies());
        stuDto.setLink_studies(stu.getLink_studies());
        stuDto.setPerson(stu.getPerson());
        
        return stuDto;
    }
}

