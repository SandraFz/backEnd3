package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.SkillDTO;
import com.portfolio.MyPortfolio8.mapper.SkillMapper;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.Skill;
import com.portfolio.MyPortfolio8.repository.IPersonRepository;
import com.portfolio.MyPortfolio8.repository.ISkillsRepository;
import com.portfolio.MyPortfolio8.service.interfaces.ISkillsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements ISkillsService {
    
    @Autowired
    public ISkillsRepository skiServ;
    
    @Autowired
    public SkillMapper mapper;
    
    @Autowired 
    public IPersonRepository persoRepo;
    
    //Crea un nuevo skill y lo vincula a la persona cuyo id se pasa por parámetro.
    @Override
    public SkillDTO createSkill(SkillDTO skiDto, Long id) {
        
        Skill sk = mapper.requestSkill(skiDto);
        Skill newSk = skiServ.save(sk);
        
        Person pers = persoRepo.getById(id);
        pers.getSkills().add(newSk);
        persoRepo.saveAndFlush(pers);
        
        SkillDTO newSkDto = mapper.responseSkill(newSk);
        
        return newSkDto;
    }
    
    //Arroja la lista de skills de la persona cuyo id se recibe por parámetro.
    @Override
    public List<SkillDTO> listSkills(Long id) {
        
        Person pers = persoRepo.getById(id);
        List<Skill> listSk = (List) pers.getSkills();
        
        List<SkillDTO> listSkDto = new ArrayList();
        
        for(Skill sk: listSk){
            
            SkillDTO skDto = mapper.responseSkill(sk);
            listSkDto.add(skDto);
        }
        return listSkDto;
    }
    
    //Busca un skill por su propio id.
    @Override
    public SkillDTO findSkill(Long id) {
        
        Skill sk = skiServ.getById(id);
        SkillDTO skDto = mapper.responseSkill(sk);
        
        return skDto;
    }
    
    //Elimina un skill por su propio id.
    @Override
    public void deleteSkill(Long idPers, Long idElem) {
        
        Person pers = persoRepo.getById(idPers);
        List<Skill> listSkills = pers.getSkills();
        Skill skill = skiServ.getById(idElem);
        listSkills.remove(skill);
        persoRepo.saveAndFlush(pers);
    }

    @Override
    public SkillDTO editSkill(Long id, SkillDTO skDto) {
        
        Skill sk = skiServ.getById(id);
        
        sk.setId(skDto.getId());
        sk.setName_skill(skDto.getName_skill());
        sk.setSkill_progress(skDto.getSkill_progress());
        sk.setPerson(skDto.getPerson());
        
        Skill editedSk = skiServ.saveAndFlush(sk);
        SkillDTO editedSkDto = mapper.responseSkill(editedSk);
        
        return editedSkDto;
    }
}


