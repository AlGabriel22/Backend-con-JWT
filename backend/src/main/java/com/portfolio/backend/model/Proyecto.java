
package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPro;
    
    private String nombreproyecto;
    private String descripcion;
    private String link;
    private String img;

    public Proyecto() {
    }

    public Proyecto(String nombreproyecto, String descripcion, String link, String img) {
        this.nombreproyecto = nombreproyecto;
        this.descripcion = descripcion;
        this.link = link;
        this.img = img;
    }
    
}
