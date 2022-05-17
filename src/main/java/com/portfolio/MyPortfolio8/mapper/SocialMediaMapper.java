package com.portfolio.MyPortfolio8.mapper;

import com.portfolio.MyPortfolio8.dto.SocialMediaDTO;
import com.portfolio.MyPortfolio8.model.SocialMedia;

public class SocialMediaMapper {

    public SocialMedia requestSocialMedia (SocialMediaDTO smDto){
        
        SocialMedia socMed = new SocialMedia();
        
        socMed.setId(smDto.getId());
        socMed.setName_SM(smDto.getName_SM());
        socMed.setLogo_SM(smDto.getLogo_SM());
        socMed.setLink_SM(smDto.getLink_SM());
        socMed.setPerson(smDto.getPerson());
        
        return socMed;
    }
    
    public SocialMediaDTO responseSocialMedia (SocialMedia socMed){
        
        SocialMediaDTO smDto = new SocialMediaDTO();
        
        smDto.setId(socMed.getId());
        smDto.setName_SM(socMed.getName_SM());
        smDto.setLogo_SM(socMed.getLogo_SM());
        smDto.setLink_SM(socMed.getLink_SM());
        smDto.setPerson(socMed.getPerson());
        
        return smDto;
    }
}


