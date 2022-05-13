package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.model.SocialMedia;
import com.portfolio.MyPortfolio8.repository.ISocMedRepository;
import com.portfolio.MyPortfolio8.service.interfaces.ISocMedService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaService implements ISocMedService {
    
    @Autowired
    public ISocMedRepository socServ;

    @Override
    public void createSocMedia(SocialMedia soc) {
        socServ.save(soc);
    }

    @Override
    public List<SocialMedia> seeListSocMed() {
        return socServ.findAll();
    }

    @Override
    public SocialMedia findSocMed(Long id) {
        return socServ.findById(id).orElse(null);
    }

    @Override
    public void deleteSocMed(Long id) {
        socServ.deleteById(id);
    }

    @Override
    public SocialMedia editSocMed(SocialMedia soc) {
        return socServ.saveAndFlush(soc);
    }
}
