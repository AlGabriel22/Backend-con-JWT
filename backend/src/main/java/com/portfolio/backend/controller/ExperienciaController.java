
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.service.ExperienciaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200")

public class ExperienciaController {
    @Autowired
    private final ExperienciaService expServ;
    
    public ExperienciaController(ExperienciaService expServ) {
        this.expServ = expServ;
    }
    
    @GetMapping("/lista")
    public List<Experiencia> verExperiencias(){
        return expServ.verExperiencias();
    }
    
    @PostMapping("/crear")
    public String crearExperiencia(@RequestBody Experiencia exp){
        expServ.crearExperiencia(exp);
        return "Experiencia creada correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?>borrarExperiencia(@PathVariable Long id){
        expServ.borrarExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia exp){
        Experiencia editarExperiencia=expServ.editarExperiencia(exp);
        return new ResponseEntity<>(editarExperiencia,HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public Experiencia editarExperiencia (@PathVariable Long id,
                                          @RequestParam("nombreempresa") String nuevaEmpresa,
                                          @RequestParam("descripcion") String nuevaDescripcion,
                                          @RequestParam("inicio") Date nuevoInicio,
                                          @RequestParam("fin") Date nuevoFin,
                                          @RequestParam("imglogo") String nuevoImglogo){
        
        Experiencia exp = expServ.buscarExperiencia(id);
        
        exp.setNombreempresa(nuevaEmpresa);
        exp.setDescripcion(nuevaDescripcion);
        exp.setInicio(nuevoInicio);
        exp.setFin(nuevoFin);
        exp.setImglogo(nuevoImglogo);
        
        expServ.crearExperiencia(exp);
        
        return exp;
    }
}
