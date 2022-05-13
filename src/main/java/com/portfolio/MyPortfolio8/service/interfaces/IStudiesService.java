package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.model.Study;
import java.util.List;

public interface IStudiesService {

    public void createStudy(Study stud);
    public List<Study> seeListStudies();
    public Study findStudy(Long id);
    public void deleteStudy(Long id);
    public Study editStudy(Study stud);
}
