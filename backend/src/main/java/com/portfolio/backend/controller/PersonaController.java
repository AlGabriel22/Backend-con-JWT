
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.PersonaService;
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
@RequestMapping("persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private final PersonaService persoServ;
    
    public PersonaController(PersonaService persoServ) {
        this.persoServ = persoServ;
    }
    
    
    @GetMapping("/lista")
    public List<Persona> verPersonas(){
        return persoServ.verPersonas();
    }
    
    @PostMapping("/crear")
    public String crearPersona(@RequestBody Persona perso){
        persoServ.crearPersona(perso);
        return "La persona fue creada correctamente";
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona perso){
        Persona editarPersona=persoServ.editarPersona(perso);
        return new ResponseEntity<>(editarPersona,HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
        
    }
   
    @PutMapping("/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("apellido") String nuevoApellido,
                                 @RequestParam("ocupacion") String nuevaOcupacion,
                                 @RequestParam("imgbanner") String nuevoBanner,
                                 @RequestParam("imgperfil") String nuevoPerfil,
                                 @RequestParam("acercade") String nuevoAcercade){
        
        Persona perso = persoServ.buscarPersona(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setOcupacion(nuevaOcupacion);
        perso.setImgbanner(nuevoBanner);
        perso.setImgperfil(nuevoPerfil);
        perso.setAcercade(nuevoAcercade);
        
        persoServ.crearPersona(perso);
        return perso;
        
    }
    
    @GetMapping("/traer/{id}")
        public Persona buscarPersona(@PathVariable("id")Long id){
            Persona perso = persoServ.buscarPersona(id);
                return perso;                        
        }
}
