package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.model.SocialMedia;
import java.util.List;

public interface ISocMedService {

    public void createSocMedia(SocialMedia soc);
    public List<SocialMedia> seeListSocMed();
    public SocialMedia findSocMed(String id);
    public void deleteSocMed(String id);
    public SocialMedia editSocMed(SocialMedia soc);
}
