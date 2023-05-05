
package com.portfolio.backend.service;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService{
    private final PersonaRepository persoRepo;
    
    @Autowired
    public PersonaService(PersonaRepository persoRepo){
        this.persoRepo = persoRepo;
    }
    
    public List<Persona> verPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;
    }

    public void crearPersona(Persona perso) {
        persoRepo.save(perso);
    }

    public void borrarPersona(Long id) {
       persoRepo.deleteById(id);
    }
    
    public Persona editarPersona(Persona perso){
        return persoRepo.save(perso);
    }
    
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
        
    }
    
}
