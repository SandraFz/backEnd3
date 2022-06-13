package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.StudyDTO;
import com.portfolio.MyPortfolio8.model.Person;
import java.util.List;

public interface IStudiesService {

    public StudyDTO createStudy(StudyDTO stuDto, Long id);
    public List<StudyDTO> listStudies(Long id);
    public StudyDTO findStudy(Long id);
    public void deleteStudy(Long id);
    public StudyDTO editStudy(Long id, StudyDTO stuDto);
   // public void findOwner(Long id);
}
