
package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectoService {
    private final ProyectoRepository proyectRepo;
    
    @Autowired
    public ProyectoService(ProyectoRepository proyectRepo){
        this.proyectRepo = proyectRepo;
    }
   
    public List<Proyecto> verProyectos() {
        List<Proyecto> listaProyectos = proyectRepo.findAll();
        return listaProyectos;
    }

    public Proyecto crearProyecto(Proyecto pro) {
        return proyectRepo.save(pro);
    }
    
    public Proyecto editarProyecto(Proyecto pro){
        return proyectRepo.save(pro);
    }
    
    public void borrarProyecto(Long id) {
        proyectRepo.deleteById(id);
    }

    public Proyecto buscarProyecto(Long id) {
        Proyecto pro = proyectRepo.findById(id).orElse(null);
        return pro;
    }
    
}
