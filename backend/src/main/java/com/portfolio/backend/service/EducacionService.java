
package com.portfolio.backend.service;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {
    
    private final EducacionRepository eduRepo;
    
    @Autowired
    public EducacionService(EducacionRepository eduRepo) {
        this.eduRepo = eduRepo;
    }
    
    public List<Educacion> verEducacion(){
        List<Educacion> listaEducacion = eduRepo.findAll();
        return listaEducacion;
    }
    
    public void crearEducacion(Educacion edu) {
        eduRepo.save(edu);
    }
    
    public Educacion editarEducacion(Educacion edu){
        return eduRepo.save(edu);
    }
    
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    public Educacion buscarEducacion(Long id) {
        Educacion edu = eduRepo.findById(id).orElse(null);
        return edu;
    }
    
}
