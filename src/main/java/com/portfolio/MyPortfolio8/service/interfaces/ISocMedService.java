package com.portfolio.MyPortfolio8.service.interfaces;

import com.portfolio.MyPortfolio8.dto.SocialMediaDTO;
import java.util.List;

public interface ISocMedService {

    public SocialMediaDTO createSocMedia(SocialMediaDTO smDto, Long id);
    public List<SocialMediaDTO> listSocMed(Long id);
    public SocialMediaDTO findSocMed(Long id);
    public void deleteSocMed(Long idPers, Long idElem);
    public SocialMediaDTO editSocMed(Long id, SocialMediaDTO sMedDto);
}
