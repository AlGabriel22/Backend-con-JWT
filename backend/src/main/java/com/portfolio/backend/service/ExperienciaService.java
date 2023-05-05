
package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    
    private final ExperienciaRepository expRepo;
    
    @Autowired
    public ExperienciaService(ExperienciaRepository expRepo) {
        this.expRepo = expRepo;
    }
    
    public List<Experiencia> verExperiencias() {
        List<Experiencia> listaExperiencias = expRepo.findAll();
        return listaExperiencias;
    }

    public Experiencia crearExperiencia(Experiencia exp) {
        return expRepo.save(exp);
    }

    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    public Experiencia buscarExperiencia(Long id) {
        Experiencia exp = expRepo.findById(id).orElse(null);
        return exp;
    }

    public Experiencia editarExperiencia(Experiencia exp){
        return expRepo.save(exp);
    }
    
}
