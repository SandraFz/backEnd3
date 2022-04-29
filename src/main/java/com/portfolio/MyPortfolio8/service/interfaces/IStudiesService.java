package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.model.Studies;
import java.util.List;

public interface IStudiesService {

    public void createStudy(Studies stud);
    public List<Studies> seeListStudies();
    public Studies findStudy(Long id);
    public void deleteStudy(Long id);
    public Studies editStudy(Studies stud);
}
