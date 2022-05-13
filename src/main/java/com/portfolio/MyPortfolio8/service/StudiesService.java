package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.model.Study;
import com.portfolio.MyPortfolio8.repository.IStudiesRepository;
import com.portfolio.MyPortfolio8.service.interfaces.IStudiesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudiesService implements IStudiesService {
    
    @Autowired
    public IStudiesRepository studService;

    @Override
    public void createStudy(Study stud) {
        studService.save(stud);
    }

    @Override
    public List<Study> seeListStudies() {
        return studService.findAll();
    }

    @Override
    public Study findStudy(Long id) {
        return studService.findById(id).orElse(null);
    }

    @Override
    public void deleteStudy(Long id) {
        studService.deleteById(id);
    }

    @Override
    public Study editStudy(Study stud) {
        return studService.saveAndFlush(stud);
    }
}
