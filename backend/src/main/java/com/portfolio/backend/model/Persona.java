
package com.portfolio.backend.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    
    private String ocupacion;
    
    private String imgbanner;
    
    private String imgperfil;
    
    private String acercade;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencia>experienciaList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion>educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idSkill")
    private List<Skill>skillList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPro")
    private List<Proyecto>proyectosList;
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String ocupacion, String imgbanner, String imgperfil, String acercade) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ocupacion = ocupacion;
        this.imgbanner = imgbanner;
        this.imgperfil = imgperfil;
        this.acercade = acercade;
    }

}
