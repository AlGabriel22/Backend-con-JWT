
package com.portfolio.backend.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExp;
    
    private String nombreempresa;
    private String descripcion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;
    private String imglogo;

    public Experiencia() {
    }

    public Experiencia(String nombreempresa, String descripcion, Date inicio, Date fin, String imglogo) {
        this.nombreempresa = nombreempresa;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.imglogo = imglogo;
    }
    
    
}
