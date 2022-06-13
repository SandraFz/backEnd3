package com.portfolio.MyPortfolio8.service;

import com.portfolio.MyPortfolio8.dto.StudyDTO;
import com.portfolio.MyPortfolio8.mapper.StudyMapper;
import com.portfolio.MyPortfolio8.model.Person;
import com.portfolio.MyPortfolio8.model.Study;
import com.portfolio.MyPortfolio8.repository.IPersonRepository;
import com.portfolio.MyPortfolio8.repository.IStudiesRepository;
import com.portfolio.MyPortfolio8.service.interfaces.IStudiesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudiesService implements IStudiesService {
    
    @Autowired
    public IStudiesRepository stuRepo;
    
    @Autowired
    public IPersonRepository persoRepo;
    
    @Autowired
    public StudyMapper mapper;

    
    //Crea un nuevo estudio y lo vincula a la persona cuyo id se pasa por parámetro.
    @Override
    public StudyDTO createStudy(StudyDTO stuDto, Long id) {
        
        Study stu = mapper.requestStudy(stuDto);
        Study newStu = stuRepo.save(stu);
        
        Person pers = persoRepo.getById(id);
        pers.getStudy().add(stu);
        persoRepo.saveAndFlush(pers);
        
        StudyDTO newStuDto = mapper.responseStudy(newStu);
        
        return newStuDto;
    }
    
    //Arroja la lista de estudios de la persona cuyo id se recibe por parámetro.
    @Override
    public List<StudyDTO> listStudies(Long id) {
        
        Person pers = persoRepo.getById(id);
        List<Study> listStu = (List) pers.getStudy();
        
        List<StudyDTO> listStuDto = new ArrayList();
        
        for (Study stu: listStu){
            
            StudyDTO stuDto = mapper.responseStudy(stu);
            listStuDto.add(stuDto);
        }
        
        return listStuDto;
    }
    
    //Busca un estudio por su propio id.
    @Override
    public StudyDTO findStudy(Long id) {
        
        Study stu = stuRepo.getById(id);
        StudyDTO stuDto = mapper.responseStudy(stu);
        
        return stuDto;
    }
    
    //Elimina un estudio por su propio id.
    @Override
    public void deleteStudy(Long id) {
        stuRepo.deleteById(id);
    }
    
    //Edita un estudio y lo devuelve convertido en DTO.
    @Override
    public StudyDTO editStudy(Long id, StudyDTO stuDto) {
        
        Study stu = stuRepo.getById(id);
        
        stu.setId(stuDto.getId());
        stu.setInsti_studios(stuDto.getInsti_studios());
        stu.setTitle_studies(stuDto.getTitle_studies());
        stu.setAnio_iniStudy(stuDto.getAnio_iniStudy());
        stu.setAnio_end(stuDto.getAnio_end());
        stu.setLogo_studies(stuDto.getLogo_studies());
        stu.setLink_studies(stuDto.getLink_studies());
        stu.setPerson(stuDto.getPerson());
        
        Study editedStu = stuRepo.saveAndFlush(stu);
        StudyDTO editedStuDto = mapper.responseStudy(editedStu);
        
        return editedStuDto;
    }
    
    //Devuelve la persona a la que pertence por el id del elemento.
   /* @Override
    public void findOwner(Long id){
        Study study = stuRepo.getById(id);
        Person person = study.getPerson();
        Long id = person.getId_person();
        List<Study> listStu = person.getStudy();
        listStu.remove(study);
        persoRepo.saveAndFlush(person);
    }*/
}



