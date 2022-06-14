package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.SocialMediaDTO;
import com.portfolio.MyPortfolio8.mapper.SocialMediaMapper;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.SocialMedia;
import com.portfolio.MyPortfolio8.repository.IPersonRepository;
import com.portfolio.MyPortfolio8.repository.ISocMedRepository;
import com.portfolio.MyPortfolio8.service.interfaces.ISocMedService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaService implements ISocMedService {
    
    @Autowired
    public ISocMedRepository sMedServ;
    
    @Autowired
    public SocialMediaMapper mapper;
    
    @Autowired
    public IPersonRepository persoRepo;

    //Agrega una nueva red social y lo vincula a la persona cuyo id se pasa por parámetro.
    @Override
    public SocialMediaDTO createSocMedia(SocialMediaDTO sMedDto, Long id) {
        
        SocialMedia sMed = mapper.requestSocialMedia(sMedDto);
        SocialMedia newSMed = sMedServ.save(sMed);
        
        Person pers = persoRepo.getById(id);
        pers.getSoc_med().add(newSMed);
        persoRepo.saveAndFlush(pers);
        
        SocialMediaDTO newSMedDto = mapper.responseSocialMedia(newSMed);
        
        return newSMedDto;
    }
    
    //Arroja la lista de redes sociales de la persona cuyo id se recibe por parámetro.
    @Override
    public List<SocialMediaDTO> listSocMed(Long id) {
        
        Person pers = persoRepo.getById(id);
        List<SocialMedia> listSMed = (List) pers.getSoc_med();
        
        List<SocialMediaDTO> listSMedDto = new ArrayList();
        
        for(SocialMedia sMed: listSMed){
            
            SocialMediaDTO sMedDto = mapper.responseSocialMedia(sMed);
            listSMedDto.add(sMedDto);
        }
        return listSMedDto;
    }

    //Busca una red social por su propio id.
    @Override
    public SocialMediaDTO findSocMed(Long id) {
        
        SocialMedia sMed = sMedServ.getById(id);
        SocialMediaDTO sMedDto = mapper.responseSocialMedia(sMed);
        
        return sMedDto;
    }

    //Elimina una red social por su id.
    @Override
    public void deleteSocMed(Long idPers, Long idElem) {
        
        Person pers = persoRepo.getById(idPers);
        List<SocialMedia> listSocMed = pers.getSoc_med();
        SocialMedia socMed = sMedServ.getById(idElem);
        listSocMed.remove(socMed);
        persoRepo.saveAndFlush(pers);
    }

    @Override
    public SocialMediaDTO editSocMed(Long id, SocialMediaDTO sMeDto) {
        
        SocialMedia sMed = sMedServ.getById(id);
        
        sMed.setId(sMeDto.getId());
        sMed.setName_SM(sMeDto.getName_SM());
        sMed.setLogo_SM(sMeDto.getLogo_SM());
        sMed.setLink_SM(sMeDto.getLink_SM());
        sMed.setPerson(sMeDto.getPerson());
        
        SocialMedia editedSocMed = sMedServ.saveAndFlush(sMed);
        SocialMediaDTO editedSocMedDto = mapper.responseSocialMedia(editedSocMed);
        
        return editedSocMedDto;
    }
}

