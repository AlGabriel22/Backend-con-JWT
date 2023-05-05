
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Skill;
import com.portfolio.backend.service.SkillService;
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
@RequestMapping("skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
    @Autowired
    private final SkillService skillServ;
    
    public SkillController(SkillService skillServ) {
        this.skillServ = skillServ;
    }
    
    @GetMapping("/traer")
    public List<Skill> verSkills(){
        return skillServ.verSkills();
    }
    
    @PostMapping("/crear")
    public String crearSkill(@RequestBody Skill sk){
        skillServ.crearSkill(sk);
        return "Skill creada correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?>borrarSkill(@PathVariable Long id){
        skillServ.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Skill>editarSkill(@RequestBody Skill sk){
        Skill editarSkill=skillServ.editarSkill(sk);
        return new ResponseEntity<>(editarSkill,HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public Skill editarSkill(@PathVariable Long id,
                                 @RequestParam("nombreskill") String nuevoNombreskill,
                                 @RequestParam("porcentaje") String nuevoPorcentaje){
                               
        
        Skill sk = skillServ.buscarSkill(id);
        
        sk.setNombreskill(nuevoNombreskill);
        sk.setPorcentaje(0);
        
        skillServ.crearSkill(sk);
        return sk;
    }
}
